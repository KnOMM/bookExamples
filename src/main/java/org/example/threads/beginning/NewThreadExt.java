package org.example.threads.beginning;

public class NewThreadExt extends Thread {

    public NewThreadExt() {
        // create a thread
        super("Demo Thread ext");
        System.out.println("Child thread ext: " + this);
    }

//    entry point for thr thread

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread ext: " + i);
                Thread.sleep(750);
            }
        } catch (InterruptedException e){
            System.out.println("Ext child thread interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}
