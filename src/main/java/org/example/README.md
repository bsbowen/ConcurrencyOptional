(Optional) Assignment: Concurrency
Due Wednesday by 11pm Points 0 Submitting a text entry box or a website url
Implement a simple producer-consumer problem

Create a Java program that simulates a producer-consumer scenario. The producer generates random numbers and puts them into a shared buffer, while the consumer takes the numbers from the buffer and calculates their sum. Use threads, synchronization, and the wait() and notifyAll() methods to ensure proper coordination between the producer and consumer.


Set up a new Java project in your preferred IDE or text editor.

Define a SharedBuffer class to handle the shared buffer between producer and consumer threads. Implement the following functionalities:

a. Store and manage the buffer.

b. Limit the maximum buffer size.

c. Provide synchronized methods for adding elements to and removing elements from the buffer.

d. Use wait() and notifyAll() methods to coordinate access to the buffer.

Implement a Consumer class that represents the consumer thread. This class should:

a. Accept a reference to the SharedBuffer object.

b. Retrieve numbers from the shared buffer using the appropriate synchronized method.

c. Calculate the sum of the retrieved numbers.

In the main method or a separate Main class:

a. Create an instance of the SharedBuffer class with a specified maximum size.

b. Instantiate the Producer and Consumer classes, passing the SharedBuffer instance to both.

c. Create two Thread objects, one for the producer and one for the consumer, using the instances created in the previous step.

d. Start both threads.

Test the program to ensure that the producer generates random numbers, the consumer calculates their sum, and proper coordination is maintained between the two threads using synchronization, wait(), and notifyAll() methods.

Implement a Producer class that represents the producer thread. This class should:

a. Accept a reference to the SharedBuffer object.

b. Generate random numbers.

c. Add the random numbers to the shared buffer using the appropriate synchronized method.

