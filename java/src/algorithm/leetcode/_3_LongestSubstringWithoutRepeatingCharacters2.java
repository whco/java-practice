package algorithm.leetcode;

import java.util.HashMap;

public class _3_LongestSubstringWithoutRepeatingCharacters2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charPos = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int end = 0; end < s.length(); ++end){
            char c = s.charAt(end);
            Integer putResult = charPos.put(c, end);
            if(putResult != null){
                start = Math.max(start, putResult + 1);
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
