/**
 * 
 */
package com.npickard.waitnotify;

/**
 * @author nigel
 *
 */
public class StartApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MessageDropBox messageDropBox = new MessageDropBox();
        (new Thread(new MessageProducer(messageDropBox))).start();  //sets the messages in the when it can in the message dropbox
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        (new Thread(new MessageConsumer(messageDropBox))).start();  //gets the messages when it can from the message dropbox
	}

}
