package basics.multiThread;

public class ShareMemoryExample {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        // User1 스레드 생성
        User1 user1 = new User1();
        // 공유 객체 설정
        user1.setCalculator(calculator);
        user1.start();

        // User2 스레드 생성
        User2 user2 = new User2();
        // 공유 객체 설정
        user2.setCalculator(calculator);
        user2.start();
        // setMemory에 synchronized 붙이기 전에는 같은 수, 후에는 각각 수



    }
}
