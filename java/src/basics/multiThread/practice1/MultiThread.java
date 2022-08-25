package basics.multiThread.practice1;

public class MultiThread {
    public static void main(String[] args) {
        Runnable task = new Task();
        Thread thread = new Thread(task);
    }
}
