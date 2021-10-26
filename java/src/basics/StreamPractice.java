package basics;

public class StreamPractice {
    public static void main(String[] args) {
        int n = 1;
        String s = "ab z";
        System.out.println(new String(s.chars().map(e -> e == ' ' ? e : e < 'a' ? 'A' + (e + n - 'A') % 26 : 'a' + (e + n - 'a') % 26).toArray(), 0, s.length()));
        System.out.println((int)'a');
        System.out.println((int)'A');
//        System.out.println(new String(s.chars().in));
    }
}
