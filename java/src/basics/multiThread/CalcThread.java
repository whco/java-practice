package basics.multiThread;

public class CalcThread extends Thread{
    public CalcThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        long beforeTime = System.nanoTime();
        for (long i = 0; i < 2e8; i++) {
        }
        long afterTime = System.nanoTime();
        System.out.println(getName() + " : " + (afterTime - beforeTime) / (double)1e6 + "ms");
    }
}
