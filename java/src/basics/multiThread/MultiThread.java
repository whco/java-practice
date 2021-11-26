package basics.multiThread;

public class MultiThread {
    public static void main(String[] args) {
        Runnable task = new Task();
        Thread thread = new Thread(task);
    }
}
