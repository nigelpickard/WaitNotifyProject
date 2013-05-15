package com.npickard.waitnotify;

/*
wait( ) tells the calling thread to give up the monitor and go to sleep until some other 
thread enters the same monitor and calls notify( ).
notify( ) wakes up the first thread that called wait( ) on the same object.
notifyAll( ) wakes up all the threads that called wait( ) on the same object. The 
highest priority thread will run first.
*/
public class MessageDropBox {
    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait for producer to send message,
    // false if producer should wait for consumer to retrieve message.
    private boolean noMessage = true;

    public synchronized String takeMessage() {
        // Wait until message is available.
        while (noMessage) {
            try {
                wait();  //give up this lock to other threads
            } catch (InterruptedException e) {
            	System.out.println("Exception: " + e.toString());
            }
        }
        // Toggle status.
        noMessage = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
    }

    public synchronized void setMessage(String message) {
        // Wait until message has been retrieved.
        while (!noMessage) {
            try { 
                wait(); //gives up this thread to other locks
            } catch (InterruptedException e) {
            	System.out.println("Exception: " + e.toString());
            }
        }
        // Toggle message status.
        noMessage = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
}