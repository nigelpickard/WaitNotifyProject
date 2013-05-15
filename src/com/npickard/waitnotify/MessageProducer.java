package com.npickard.waitnotify;

import java.util.Random;

public class MessageProducer implements Runnable {
    private MessageDropBox messageDropBox;

    public MessageProducer(MessageDropBox messageDropBox) {
        this.messageDropBox = messageDropBox;
    }

    public void run() {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            messageDropBox.setMessage(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
            	
            }
        }
        messageDropBox.setMessage("DONE");
    }
}
