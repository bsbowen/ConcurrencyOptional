package org.example;

public class ShutdownHookRunnable implements Runnable {
    private final Thread producerThread;
    private final Thread consumerThread;

    public ShutdownHookRunnable(Thread producerThread, Thread consumerThread) {
        this.producerThread = producerThread;
        this.consumerThread = consumerThread;
    }

    @Override
    public void run() {
        System.out.println("Shutting down the threads...");
        producerThread.interrupt(); // Interrupt the producer thread
        consumerThread.interrupt(); // Interrupt the consumer thread
    }
}