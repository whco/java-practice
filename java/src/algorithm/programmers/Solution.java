package algorithm.programmers;

public class Solution {
    public static String convertArrayString(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if(c == '[')
                sb.append('{');
            else if (c == ']')
                sb.append('}');
            else sb.append(c);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        convertArrayString("[1, 5, 2, 6, 3, 7, 4]");
        convertArrayString("[[2, 5, 3], [4, 4, 1], [1, 7, 3]]");
        convertArrayString("[5, 6, 3]");

    }
}
