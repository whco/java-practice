package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SetExpression {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] op = br.readLine().split(" ");
//            System.out.println(op[0] + op[1] + op[2]);
            int a = Integer.parseInt(op[1]);
            int b = Integer.parseInt(op[2]);
            if(op[0].equals("0")){
                parent = unionParent(a, b, parent);
            }
            else if(op[0].equals("1")){
                sb.append(getParent(a, parent) == getParent(b, parent) ? "YES" : "NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int getParent(int n, int[] parent){
        if(parent[n] == n) return n;
        return parent[n] = getParent(parent[n], parent);
    }

    public static int[] unionParent(int a, int b, int[] parent){
        a = getParent(a, parent);
        b = getParent(b, parent);
        if(a < b) parent[b] = a;
        else parent[a] = b;
        return parent;
    }
}
