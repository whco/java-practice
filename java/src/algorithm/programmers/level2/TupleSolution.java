package algorithm.programmers.level2;

import java.util.*;

public class TupleSolution {
    public static void main(String[] args) {
        TupleSolution s = new TupleSolution();
        int[] answer = s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        for(int e : answer) System.out.print(e + " ");
    }

    public int[] solution(String s) {
        String[] tuples = splitIntoTuples(s);
        int[] result = new int[tuples.length];
        Dict[] dicts = strArrToDictArr(tuples);
        Arrays.sort(dicts);
        for (int i = dicts.length - 1; i >= 1; i--) {
            result[i] = findMissingIntFromSource(dicts[i - 1], dicts[i]);
        }
        result[0] = Integer.parseInt(dicts[0].set.iterator().next());
        return result;
    }

    private int findMissingIntFromSource(Dict source, Dict target) {
        for(String s : target.set)
            if(!source.set.contains(s))
                return Integer.parseInt(s);
        return -1;
    }

    private String[] splitIntoTuples(String s) {
        s = cutEnds(s);
        String[] tuples = s.split("\\}\\,\\{");
        tuples[0] = cutFront(tuples[0]);
        tuples[tuples.length - 1] = cutEnd(tuples[tuples.length - 1]);
        return tuples;
    }

    private String cutFront(String s) {
        return s.substring(1);
    }

    private String cutEnd(String s) {
        return s.substring(0, s.length() - 1);
    }

    private String cutEnds(String s) {
        return s.substring(1, s.length() - 1);
    }

    class Dict implements Comparable<Dict>{
        Set<String> set;

        public Dict(String[] tuple) {
            this.set = new HashSet<String>(Arrays.asList(tuple));
        }

        @Override
        public int compareTo(Dict o) {
            return ((Integer)set.size()).compareTo(o.set.size());
        }
    }

    private int[] strArrToIntArr(String[] strArr) {
        return Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
    }

    private Dict[] strArrToDictArr(String[] strArr) {
        return Arrays.stream(strArr).map(s -> new Dict(s.split(","))).toArray(Dict[]::new);
    }

}
