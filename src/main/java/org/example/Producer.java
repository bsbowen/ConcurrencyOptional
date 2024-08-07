package org.example;

import java.util.Random;

public class Producer implements Runnable {
    private SharedBuffer buffer; // Shared buffer reference
    private volatile boolean running = true; // Flag to control running state

    // Constructor to initialize the producer with a shared buffer reference
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random(); // Create a Random object to generate random numbers
        while (running) { // Check the running flag
            int number = random.nextInt(100); // Generate a random number between 0 and 99
            buffer.add(number); // Add the number to the buffer
            System.out.println("Produced: " + number); // Print the produced number
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds to simulate production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
        }
        System.out.println("Producer has stopped.");
    }

    public void shutdown() {
        running = false; // Set the flag to false to stop the thread
    }
}