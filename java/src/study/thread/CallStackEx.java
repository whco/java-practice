package study.thread;

public class CallStackEx {
    public static void main(String[] args) {
        Thread t1 = new ThrowingExceptionThread();
        t1.start();

        Thread t2 = new ThrowingExceptionThread();
        t2.run();
    }
}

class ThrowingExceptionThread extends Thread {
    @Override
    public void run() {
        throwException();
    }

    private void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

