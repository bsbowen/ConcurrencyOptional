package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
        private Queue<Integer> buffer = new LinkedList<>();//Que to store integers
        private int maxSize; //maximum size of the buffer

         //Constructor to initialize the butter with a maximum size
         public SharedBuffer(int maxSize) {
        this.maxSize = maxSize;
        }

        //Synchronize method to add an element to the buffer
        public synchronized void add(int value) {
            while (buffer.size() == maxSize) {
                try {
                    wait(); //makes the current thread wait until notified

                } catch (InterruptedException e) {
                    e.printStackTrace(); //Print the stack trace if an interruption occurs
                }
            }
            buffer.add(value); //Add value to the buffer
            notifyAll(); //notify all waiting threads that the buffer state has changed
        }
        //Synchronize method to remove an element from the buffer
        public synchronized int remove() {
             //wait if buffer is empty
             while (buffer.isEmpty()) {
                 try {
                     wait(); //makes the current thread wait until notified
                 }catch (InterruptedException e) {
                     e.printStackTrace(); //Print the stack trace if an interruption occurs
                 }
             }
             int value = buffer.poll(); //Remove and return the first element from the buffer
             notifyAll(); //Notify all waiting threads that the buffer state has changed
             return value; //Return the removed element
        }
}
