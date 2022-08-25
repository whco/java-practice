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
//        System.out.println(bracketsToBraces("[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]"));
//        System.out.println(bracketsToBraces("[[\"MO 12:00 WE 14:30\", \"MO 12:00\", \"MO 15:00\", \"MO 18:00\"], [\"TU 09:00\", \"TU 10:00\", \"TU 15:00\", \"TU 18:00\"], [\"WE 09:00\", \"WE 12:00\", \"WE 15:00\", \"WE 18:00\"], [\"TH 09:30\", \"TH 11:30\", \"TH 15:00\", \"TH 18:00\"], [\"FR 15:00\", \"FR 15:00\", \"FR 15:00\", \"FR 15:00\"]]"));
        System.out.println(bracketsToBraces("[[1, 50], [1, 60], [3, 70], [0, 65], [2, 50], [1, 90]]"));
    }
}
