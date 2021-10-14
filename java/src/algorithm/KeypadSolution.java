package algorithm;

import java.util.Arrays;
import java.util.HashSet;

import static java.lang.Math.abs;

class KeypadSolution {
    char hand;
    Keypad kp;
    int leftHand = 10;
    int rightHand = 11;
    public String solution(int[] numbers, String hand) {
        StringBuffer sb = new StringBuffer();
        this.hand = hand.equals("left") ? 'L' : 'R';
        this.kp = new Keypad();
        for (int number : numbers) {
            char h = calculateNextHand(number);
            sb.append(h);
            if(h == 'L') leftHand = number;
            else rightHand = number;
        }
        return sb.toString();
    }

    public char calculateNextHand(int num) {
        if (new HashSet<Integer>(Arrays.asList(1, 4, 7)).contains(num)) {
            return 'L';
        }
        if (new HashSet<Integer>(Arrays.asList(3, 6, 9)).contains(num)) {
            return 'R';
        }
        if(distance(leftHand, num) == distance(rightHand, num))
            return hand;
        return distance(leftHand, num) < distance(rightHand, num) ? 'L' : 'R';
    }

    public int distance(int a, int b) {
        return abs(kp.keypad[a][0] - kp.keypad[b][0])
                + abs(kp.keypad[a][1] - kp.keypad[b][1]);
    }

    public static void main(String[] args) {
        char x = (char) ('0' + 3);
        System.out.println(x);

        Keypad kp = new Keypad();
        kp.printKeypad();
    }
}

class Keypad {
    public int[][] keypad = new int[12][2];

    public Keypad() {
        keypad[0] = new int[]{3, 1};
        for (int i = 1; i < 10; i++) {
            keypad[i] = new int[]{(i - 1) / 3, (i - 1) % 3 };
        }
        //*, #
        keypad[10] = new int[]{3, 0};
        keypad[11] = new int[]{3, 2};
    }

    public void printKeypad() {
        for (int i = 0; i < 12; i++) {
            System.out.printf("{%d, %d}\n", keypad[i][0], keypad[i][1]);
        }
    }
}