package Threads;


public class Main {
    public static void main(String[] args) {
        Thread t1= new Thread( new Threadscomp(1));
        Thread t2= new Thread( new Threadscomp(2));
        Thread t3= new Thread( new Threadscomp(3));
        Thread t4= new Thread( new Threadscomp(4));
        
       
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
