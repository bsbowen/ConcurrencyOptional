package org.example;

public class Consumer implements Runnable {
    private SharedBuffer buffer; // Shared buffer reference
    private volatile boolean running = true; // Flag to control running state

    // Constructor to initialize the consumer with a shared buffer reference
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int sum = 0; // Initialize sum to 0
        while (running) { // Check the running flag
            int number = buffer.remove(); // Remove an element from the buffer
            sum += number; // Add the number to the sum
            System.out.println("Consumed: " + number + ", Sum: " + sum); // Print the consumed number and the current sum
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds to simulate consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
        }
        System.out.println("Consumer has stopped.");
    }

    public void shutdown() {
        running = false; // Set the flag to false to stop the thread
    }
}