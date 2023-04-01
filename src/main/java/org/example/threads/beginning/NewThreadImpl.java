package org.example.threads.beginning;

public class NewThreadImpl implements Runnable{
    Thread t;

    public NewThreadImpl() {
//        create second thread
        t = new Thread(this, "Demo Thread impl");
        System.out.println("Child thread impl: " + t);
    }

//    entry point for second thread
    @Override
    public void run() {
        try {
            for (int i = 5; i>0;i--){
                System.out.println("Child Thread impl: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Impl child interrupted.");
        }
        System.out.println("Exiting impl child thread.");
    }
}
