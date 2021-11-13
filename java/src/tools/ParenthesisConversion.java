package tools;

public class ParenthesisConversion {
    public static String bracketsToBraces(String brakets){
        StringBuffer sb = new StringBuffer();
        for(char c : brakets.toCharArray()) {
            if(c == '[') sb.append('{');
            else if(c == ']') sb.append('}');
            else sb.append(c);
        }
        return sb.toString();
    }

    public static String bracesTobrackets(String braces){
        StringBuffer sb = new StringBuffer();
        for (char c : braces.toCharArray()) {
            if(c == '{') sb.append('[');
            else if(c == '}') sb.append(']');
            else sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(bracketsToBraces("[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]"));
    }
}
