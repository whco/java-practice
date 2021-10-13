import java.security.Key;
import java.util.ArrayList;

class KeypadSolution {
    char hand;
    public String solution(int[] numbers, String hand) {
        this.hand = hand.equals("left") ? 'L' : 'R';
        Keypad kp = new Keypad();
        kp.printKeypad();
        return "";
    }

    public int[][] calculateNextHand(int num) {
        if (new HashSet<int>{1, 4, 7}) {
        }
    }

    public static void main(String[] args) {
        char x = (char) ('0' + 3);
        System.out.println(x);

        Keypad kp = new Keypad();
        kp.printKeypad();
    }
}

class Keypad {
    public int[][] keypad = new int[10][2];

    public Keypad() {
        keypad[0] = new int[]{3, 1};
        for (int i = 1; i < 10; i++) {
            keypad[i] = new int[]{(i - 1) / 3, i % 3 + 1};
        }
    }

    public void printKeypad() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("{%d, %d}\n", keypad[i][0], keypad[i][1]);
        }
    }
}