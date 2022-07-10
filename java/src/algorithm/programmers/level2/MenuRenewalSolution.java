package algorithm.programmers.level2;

import java.util.*;

public class MenuRenewalSolution {
    public static void main(String[] args) {
        MenuRenewalSolution s = new MenuRenewalSolution();
//        String[] solution = s.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        String[] solution = s.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
        for (String eachSolution : solution) {
            System.out.println(eachSolution);
        }
    }
    List<String> courseMenus = new ArrayList<>();
    String[] orders;
    Map<Integer, HashMap<String, Integer>> lengthToCountMap = new HashMap<>();


    //각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
    //코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
    // 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
    public String[] solution(String[] orders, int[] course) {
        this.orders = orders;

        iterateAllOrderCombinations();



        for(int n : course)
            courseMenus.addAll(makeMenu(n));
        return courseMenus.stream().sorted().toArray(String[]::new);
    }

    private void iterateAllOrderCombinations(){
        for(String order : orders)
            addAllCombinations(order);
    }

    private void addAllCombinations(String order) {
        for (int len = 2; len <= order.length(); len++) {
            addCombinations(order, len);
        }
    }

    private void addCombinations(String order, int len) {
        combinations(order.toCharArray(), new boolean[order.length()], order.length(), len, 0);
    }

    private void combinations(char[] arr, boolean[] visited, int n, int r, int depth) {
        if(r == 0){
            String combination = toCombination(arr, visited);
            HashMap<String, Integer> countMap = lengthToCountMap.getOrDefault(combination.length(), new HashMap<String, Integer>());
            countMap.put(combination, countMap.getOrDefault(combination, 0) + 1);
            lengthToCountMap.put(combination.length(), countMap);
            return;
        }
        if (depth == n ) {
            return;
        }
        visited[depth] = true;
        combinations(arr, visited, n, r - 1, depth + 1);
        visited[depth] = false;
        combinations(arr, visited, n, r, depth + 1);
    }

    private String toCombination(char[] arr, boolean[] visited) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            result.append(visited[i] ? arr[i] : "");
        }
        char[] chars = result.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private ArrayList<String> makeMenu(int n) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, Integer> combintationToCount = lengthToCountMap.getOrDefault(n, null);
        if(combintationToCount == null) return new ArrayList<>();

        int max = 0;
        for (String key : combintationToCount.keySet()) {
            max = Math.max(max, combintationToCount.get(key));
        }
        if(max < 2)return result;

        for (String key : combintationToCount.keySet()) {
            if(combintationToCount.get(key) == max)
                result.add(key);
        }
        return result;
    }
}
