package algorithm.leetcode;

public class _7_ReverseInteger {
    public int reverse(int x) {
        boolean negative = x < 0 ? true : false ;
        String s = ((Integer) x).toString();
        if(negative) s = s.substring(1);
        StringBuilder sb = new StringBuilder();


        if(s.length() <= 9){
            for(int i = 0; i < s.length(); ++i)
                sb.append(s.charAt(s.length() - 1 - i));
        } else {
            String posMax = ((Integer)(Integer.MAX_VALUE)).toString();
            String negMax = ((Integer)(Integer.MIN_VALUE)).toString();
            negMax = negMax.substring(1);
            if(!negative){
                for(int i = 0; i < 9; ++i){
                    sb.append(s.charAt(s.length() - 1 - i));
                }
                if(Integer.parseInt(sb.toString()) > Integer.parseInt(posMax.substring(0, 9))) return 0;
                else if(Integer.parseInt(sb.toString()) == Integer.parseInt(posMax.substring(0, 9))
                        && s.charAt(0) > posMax.charAt(9)) return 0;
                else{
                    sb.append(s.charAt(0));
                }
            } else {
                for(int i = 0; i < 9; ++i){
                    sb.append(s.charAt(s.length() - 1 - i));
                }
                if(Integer.parseInt(sb.toString()) > Integer.parseInt(negMax.substring(0, 9))) return 0;
                else if(Integer.parseInt(sb.toString()) == Integer.parseInt(negMax.substring(0, 9))
                        && s.charAt(0) > negMax.charAt(9)) return 0;
                else{
                    sb.append(s.charAt(0));
                }
            }
        }
        return Integer.parseInt(sb.toString()) * (negative ? -1 : 1);
    }
}
