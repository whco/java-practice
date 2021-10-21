package algorithm.programmers.level1;

import java.util.*;
class FailureRateSolution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stagePeopleNum = new int[N + 2];
        double[] stageFailureProb = new double[N + 2];
        for(int stage : stages)
            ++stagePeopleNum[stage];
        for(int i = N; i >= 1; --i){
            stagePeopleNum[i] += stagePeopleNum[i + 1];
            stageFailureProb[i] = (double) (stagePeopleNum[i] - stagePeopleNum[i + 1]) / stagePeopleNum[i];
            // System.out.printf("%f ", stageFailureProb[i]);
        }
        System.out.println();

        List<Stage> lst = new ArrayList<>();
        for(int i = 1; i <= N; ++i){
            lst.add(new Stage(i, stageFailureProb[i]));
        }
        Collections.sort(lst);
        for(int i = 0; i < N; ++i){
            answer[i] = lst.get(i).id;
            // System.out.printf("%f ", lst.get(i).failureProb);
        }
        return answer;

    }
}

class Stage implements Comparable<Stage> {
    int id;
    double failureProb;

    public Stage(int id, double failureProb){
        this.id = id;
        this.failureProb = failureProb;
    }

    @Override
    public int compareTo(Stage s) {
        if(this.failureProb > s.failureProb){
            return -1;
        } else if (this.failureProb < s.failureProb) {
            return 1;
        } else {
            if(this.id > s.id) {
                return 1;
            } else if(this.id < s.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
