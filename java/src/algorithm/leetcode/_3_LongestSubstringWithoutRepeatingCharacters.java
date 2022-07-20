package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    HashSet<Character> charSet = new HashSet<>();
    HashMap<Character, Integer> charPos = new HashMap<>();
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); ++i){
            if(charSet.add(s.charAt(i))){
                end = i;
                charPos.put(s.charAt(i), i);
                max = Math.max(max, end - start + 1);
            } else {
                end = i;
                int originalStart = start;
                start = charPos.get(s.charAt(i)) + 1;
                for(int idx = originalStart; idx < start; ++idx){
                    charSet.remove(s.charAt(idx));
                    charPos.remove(s.charAt(idx));
                }
                charSet.add(s.charAt(i));
                charPos.put(s.charAt(i), i);
            }
        }
        return max;
    }
}
