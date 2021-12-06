package algorithm.programmers.level2;

import java.util.ArrayList;

public class FunctionDevelopmentSolution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil( (100 - progresses[i]) / (double) speeds[i]);
        }
        int daysPast = days[0];
        int prev = 0;
        int i = 1;
        while (i < days.length) {
            if (daysPast < days[i] || i == days.length - 1) {
                if(i != days.length - 1) answer.add(i - prev);
                else {
                    if(daysPast < days[i]) {
                        answer.add(i - prev);
                        answer.add(1);
                    } else answer.add(i + 1 - prev);
                }
                prev = i;
                daysPast = days[i];
            }
            ++i;
        }
        return answer.stream().mapToInt(j -> j).toArray();
    }
}
