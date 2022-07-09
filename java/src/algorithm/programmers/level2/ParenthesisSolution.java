package algorithm.programmers.level2;

public class ParenthesisSolution {
    public static void main(String[] args) {
        ParenthesisSolution s = new ParenthesisSolution();
        String result = s.solution("(()())()");
        System.out.println(result);
        //"(()())()"	"(()())()"
        //")("	"()"
        //"()))((()"	"()(())()"
    }

    public String solution(String w) {
        //1
        if(w.isEmpty()) return w;
        //2
        UV uv = new UV();
        uv = split(w);
        //3
        if(isCorrect(uv.u)){
            return uv.u + solution(uv.v);
        }
        //4
        String s = "(";
        s += solution(uv.v);
        s += ')';
        s += reverse(cutEnds(uv.u));
        return s;
    }

    private String cutEnds(String s){
        if(s.length() <= 1) return "";
        return s.substring(1, s.length() - 1);
    }

    private String reverse(String s){
        StringBuffer result = new StringBuffer();
        for(char c : s.toCharArray())
            result.append(reverse(c));
        return result.toString();
    }

    private char reverse(char c){
        if(c == '(') return ')';
        else if(c == ')') return '(';
        //not gonna happen
        else return 'X';
    }


    private boolean isBalanced(String s) {
        int diff = 0;
        for(char c : s.toCharArray())
            if(c == '(') ++diff;
            else if(c == ')') --diff;
        return diff == 0;
    }

    UV split(String s){
        String u = "", v = "";
        int diff = 0;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') ++diff;
            else if (c == ')') --diff;
            if(diff == 0) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1);
                break;
            }
        }
        return new UV(u, v);
    }

    private boolean isCorrect(String s){
        if(s.isEmpty() || s.equals("()")) return true;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.substring(i, i + 2).equals("()"))
                return isCorrect(s.substring(0, i) + s.substring(i + 2));
        }
        return false;
    }

    class UV {
        String u;
        String v;

        public UV(){}

        public UV(String u, String v) {
            this.u = u;
            this.v = v;
        }
    }

}
