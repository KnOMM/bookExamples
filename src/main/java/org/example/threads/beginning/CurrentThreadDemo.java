package org.example.threads.beginning;

public class CurrentThreadDemo {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Current thread: " + t);
        // change the name of the thread
        t.setName("My Thread");
        System.out.println("After name change: " + t);

        // create a new thread impl
        NewThreadImpl nti = new NewThreadImpl();
        nti.t.start(); // start the thread
        // create a new thread ext
        NewThreadExt nte = new NewThreadExt();
        nte.start();

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("Main thread: " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}
