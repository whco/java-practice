package study.thread;

public class RunnableAndThread {
    public static void main(String[] args) {
        //thread 및 runnable 사용방법
        Thread threadByThread = new Thread1();
        Runnable runnable = new Runnable1();
        Thread threadByRunnable = new Thread(runnable);

        System.out.println(Thread.currentThread().getName());
        threadByThread.start();
        threadByRunnable.start();


    }
}
class Runnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}
