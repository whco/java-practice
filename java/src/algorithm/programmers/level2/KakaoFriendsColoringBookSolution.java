package algorithm.programmers.level2;

public class KakaoFriendsColoringBookSolution {
    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] checked;
    static int size = 0;

    public static void dfs(int[][] picture, int x, int y){
        if(checked[x][y]) return;
        checked[x][y] = true;
        ++size;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) continue;
            if(picture[x][y] == picture[nx][ny] && !checked[nx][ny])
                dfs(picture, nx, ny);
        }
    }

    public int[] solution(int m, int n, int[][] picture){
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        checked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !checked[i][j]){
                    ++numberOfArea;
                    dfs(picture, i, j);
                }
                if(size > maxSizeOfOneArea) maxSizeOfOneArea = size;
                size = 0;
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    public static void main(String[] args) {
        KakaoFriendsColoringBookSolution sol = new KakaoFriendsColoringBookSolution();
        int[][] p = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] ans = sol.solution(6, 4, p);
        for(int a : ans)
            System.out.print(a + " ");
    }
}
