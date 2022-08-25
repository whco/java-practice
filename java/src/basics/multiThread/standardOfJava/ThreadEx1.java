package basics.multiThread.standardOfJava;

public class ThreadEx1 {
    public static void main(String[] args) {
        ThreadByThread t1 = new ThreadByThread();

        ThreadByRunnable r = new ThreadByRunnable();
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}

class ThreadByThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}

class ThreadByRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
