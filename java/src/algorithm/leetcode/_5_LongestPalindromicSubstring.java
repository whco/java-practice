package algorithm.leetcode;

public class _5_LongestPalindromicSubstring {
    String longestPalindrome = "";
    String s;
    public String longestPalindrome(String s) {
        //O(n^2) solution
        this.s = s;
        for(int mid = 0; mid < s.length(); ++ mid){
            //odd length case
            int side = 0;
            while(mid - side >= 0 && mid + side < s.length() && s.charAt(mid - side) == s.charAt(mid + side)) ++side;
            --side;
            setLongerString(mid - side, mid + side + 1);

            //even length case
            if(mid + 1 < s.length() && s.charAt(mid) == s.charAt(mid + 1)){
                int evenSide = 0;
                while(mid - evenSide >= 0 && mid + 1 + evenSide < s.length() && s.charAt(mid - evenSide) == s.charAt(mid + 1 + evenSide)) ++evenSide;
                --evenSide;
                setLongerString(mid - evenSide, mid + 1 + evenSide + 1);
            }
        }
        return longestPalindrome;
    }
    private void setLongerString(int start, int end){
        if(longestPalindrome.length() < end - start)
            longestPalindrome = s.substring(start, end);
    }
}
