package org.example.threads.synchronizedStatement;

class Callme {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme target, String msg) {
        this.msg = msg;
        this.target = target;
        this.t = new Thread(this);
    }

    @Override
    public void run() {
        synchronized (target){// synchronized block
            target.call(msg);
        }
    }
}


public class Synch {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller c1 = new Caller(target, "Hello");
        Caller c2 = new Caller(target, "Synchronized");
        Caller c3 = new Caller(target, "World");
        // start the threats
        c1.t.start();
        c2.t.start();
        c3.t.start();

        try {
            c1.t.join();
            c2.t.join();
            c3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("finished");
    }
}
