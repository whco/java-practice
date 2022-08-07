package algorithm.leetcode;

public class _6_ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int mod = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        int idx;
        for(int r = 0; r < numRows; ++r){
            if(r % (mod / 2) == 0){
                for(int i = 0; (idx = mod * i + r) < s.length(); ++i){
                    sb.append(s.charAt(idx));
                }
            } else {
                for(int i = 0, sign = 1; (idx = mod * i + sign * r) < s.length();){
                    sb.append(s.charAt(idx));
                    if(sign == 1) ++i;
                    sign *= -1;
                }
            }
        }
        return sb.toString();
    }
}
