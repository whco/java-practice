package study.synchronization;

public class WorkObject {

    public static void main(String[] args) {
        WorkObject workObj = new WorkObject();

        ThreadA tha = new ThreadA(workObj);
        ThreadB thb = new ThreadB(workObj);

        tha.start();
        thb.start();
    }
    public synchronized void methodA() {
        System.out.println("methodA에서 작업 중...");

        notify(); // Wait-Set영역에 있는 애들 깨우기 (깨울 애 없으면 그냥 뭐..)

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println("methodB에서 작업 중...");

        notify();

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    private WorkObject workObj;

    public ThreadA(WorkObject workObj) {
        this.workObj = workObj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObj.methodA();
        }
        System.out.println("ThreadA 종료");
    }
}

class ThreadB extends Thread {
    private WorkObject workObj;

    public ThreadB(WorkObject workObj) {
        this.workObj = workObj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObj.methodB();
        }
        System.out.println("ThreadB 종료");
    }
}