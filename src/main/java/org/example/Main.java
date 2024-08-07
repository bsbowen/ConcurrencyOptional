package org.example;

public class Main {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(10); // Create a shared buffer with a maximum size of 10

        Producer producer = new Producer(buffer); // Create a producer with the shared buffer reference
        Consumer consumer = new Consumer(buffer); // Create a consumer with the shared buffer reference

        Thread producerThread = new Thread(producer); // Create a thread for the producer
        Thread consumerThread = new Thread(consumer); // Create a thread for the consumer

        producerThread.start(); // Start the producer thread
        consumerThread.start(); // Start the consumer thread

        // Add a shutdown hook to gracefully stop the producer and consumer threads
        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHookRunnable(producerThread, consumerThread)));

        // Simulate application running
        System.out.println("Application is running!");
        System.out.println("Application will run for 10 seconds");
        try {
            Thread.sleep(10000); // Let the application run for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Initiate a controlled shutdown after the specified time
        producer.shutdown(); // Signal the producer to stop
        consumer.shutdown(); // Signal the consumer to stop
        try {
            producerThread.join(); // Wait for the producer thread to finish
            consumerThread.join(); // Wait for the consumer thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Application has finished.");
    }
}