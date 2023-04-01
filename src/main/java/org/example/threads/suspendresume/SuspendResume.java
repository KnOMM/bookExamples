package org.example.threads.suspendresume;


class NewThread implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, this.name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        ob1.t.start();
        ob2.t.start();

        try{
            System.out.println(ob1.t.getState());
            System.out.println(ob2.t.getState());
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Suspend One");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resume One");
            ob2.mysuspend();
            System.out.println("Suspend Two");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Resume Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
