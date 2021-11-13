package algorithm.programmers.level2;

class KakaoFriendsColoringBookSolutionDeprecated {
    public static int numberOfArea = 0;
    public static int maxSizeOfOneArea = 0;
    public static boolean[][] checked;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void dfs(int[][] picture, int x, int y, int color, int size){
        if(x < 0 || x >= picture.length || y < 0 || y >= picture[0].length) return;
        if(picture[x][y] != color || picture[x][y] == 0) return;
        if(checked[x][y]) return;
        checked[x][y] = true;

        ++size;
        if(size == 1) ++numberOfArea;

        if(size > maxSizeOfOneArea){
            System.out.println(size + " " + x + " " + y);
            maxSizeOfOneArea = size;
        }

        for (int i = 0; i < 4; i++) {
            dfs(picture, x + dx[i], y + dy[i], color, size);
        }
    }

    public int[] solution(int m, int n, int[][] picture) {

        checked = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(picture, i, j, picture[i][j], 0);
            }
        }
//        dfs(picture, 0, 0, picture[0][0], 1);


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        KakaoFriendsColoringBookSolutionDeprecated sol = new KakaoFriendsColoringBookSolutionDeprecated();
        int[][] p = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] ans = sol.solution(6, 4, p);
        for(int a : ans)
            System.out.print(a + " ");
    }
}