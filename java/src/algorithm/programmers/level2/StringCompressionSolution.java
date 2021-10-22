package algorithm.programmers.level2;

class StringCompressionSolution {
    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i <= s.length() / 2; ++i){
            String c = compress(s, i);
            if(c.length() < answer){
                answer = c.length();
                System.out.println(i + " " + c);
            }
        }
        return answer;
    }

    public static String compress(String s, int n) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(i + n <= s.length()) {
            int cnt = 0;
            String sub = s.substring(i, i + n);
            while (i + n <= s.length() && s.substring(i, i + n).equals(sub)) {
                ++cnt;
                i += n;
            }

            if (cnt == 1) {
                sb.append(sub);
            } else {
                sb.append(Integer.toString(cnt));
                sb.append(sub);
            }
        }
        if(i < s.length())
            sb.append(s.substring(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aabbaccc",3));
    }

//    public static String compress(String s, int n, StringBuffer sb, String sub, int pos, int cnt){
//
//    }
}

class StringCompressionSolutionRecursive {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i < s.length() / 2; i++) {
            int len = getSplitedLength(s, i, 1).length();
            answer = len < answer ? len : answer;
        }
        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat) {
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n);

        if (!postString.startsWith(preString)) {
            if (repeat == 1) {
                return result += preString + getSplitedLength(postString, n, 1);
            } else {
                return result += repeat + preString + getSplitedLength(postString, n, 1);
            }
        }
        return result += getSplitedLength(postString, n, repeat + 1);
    }
}
