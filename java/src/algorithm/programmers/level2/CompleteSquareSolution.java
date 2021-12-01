package algorithm.programmers.level2;

public class CompleteSquareSolution {
    public long solution(int w, int h) {
        long total = (long) w * h - w - h;
        while(w % h != 0 && h % w != 0){
            if(w > h) w -= h * (w / h);
            else h -= w * (h / w);
        }
        return total + Math.min(w, h);
    }
}