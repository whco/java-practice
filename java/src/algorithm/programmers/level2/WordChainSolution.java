package algorithm.programmers.level2;

import java.util.HashSet;

public class WordChainSolution {
    public int[] solution(int n, String[] words) {
        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        for (int i = 1; i < words.length; ++i) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || hs.contains(words[i]))
                return new int[]{i % n + 1, i / n + 1};
            hs.add(words[i]);
        }
        return new int[]{0, 0};
    }
}
