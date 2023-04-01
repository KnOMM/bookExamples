package org.example.threads.race;

public class NewThread implements Runnable{
    String name; // name of thread
    Thread t;

    public NewThread(String name) {
        this.name = name;
        t = new Thread(this, name); // obligatory part to make a thread out of class
        System.out.println("New thread: " + t);
    }

    @Override
    public void run() {
        try{
            for (int i = 5; i>0;i--){
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exiting.");
    }
}
