package algorithm.programmers.level2;

public class PairRemovalSolution {
    public int solution(String s) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < s.length()) {
            if(sb.length() == 0) {
                sb.append(s.charAt(i));
                ++i;
            }
            else{
                if(sb.charAt(sb.length() - 1) == s.charAt(i)){
                    sb.deleteCharAt(sb.length() - 1);
                    ++i;
                }
                else{
                    sb.append(s.charAt(i));
                    ++i;
                }
            }
        }
        if(sb.length() == 0)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        PairRemovalSolution sol = new PairRemovalSolution();
        System.out.println(sol.solution("cdcd"));
    }
}
