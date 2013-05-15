package com.npickard.waitnotify;

import java.util.Random;

public class MessageConsumer implements Runnable {
	private MessageDropBox messageDropBox;

	public MessageConsumer(MessageDropBox messageDropBox) {
		this.messageDropBox = messageDropBox;
	}

	public void run() {
		Random random = new Random();
		boolean isDone = false;
		for (String message = messageDropBox.takeMessage(); !isDone; message = messageDropBox.takeMessage()) {
			System.out.format("MESSAGE RECEIVED: %s%n", message);
			if (message.equals("DONE")){
				isDone = true;
				break;
			}
			
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				
			}
		}
	}
}