package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeDeprecated {
    private static ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        int n = Integer.parseInt(st.nextToken());

//        Tree tree = new Tree();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            treeNodes.add(new TreeNode(p, i));;
            if(p == -1) root = i;
        }

        System.out.println(treeNodes.get(root).leafCnt);

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        if(r == root) System.out.println(0);
        else {
            treeNodes.get(r).removeNode();
            System.out.println(treeNodes.get(root).leafCnt);
        }
//        System.out.println(treeNodes.get(root).leafCnt);

    }

    private static class TreeNode {
        int idx;
        int parent;
        ArrayList<Integer> children;
        boolean isLeaf;
        int leafCnt;

        public TreeNode(int parent, int idx) {
            this.parent = parent;
            this.idx = idx;
            children = new ArrayList<>();
            isLeaf = true;
            leafCnt = 1;
            if(parent != -1) treeNodes.get(parent).addChildren(idx);
        }

        void addChildren(int c){
            int beforeCnt = leafCnt;
            children.add(c);
            if(isLeaf){
                isLeaf = false;
                --leafCnt;
            }
            if(c < treeNodes.size()) leafCnt += treeNodes.get(c).leafCnt;
            else ++leafCnt;

            int afterCnt = leafCnt;

            int curIdx = idx;
            int curParent = parent;
            while(curParent != -1){
                treeNodes.get(curParent).leafCnt += afterCnt - beforeCnt;
                curIdx = curParent;
                curParent = treeNodes.get(curIdx).parent;
            }
        };
        void removeChildren(int c){
            int beforeCnt = leafCnt;
            children.remove(Integer.valueOf(c));
            leafCnt -= treeNodes.get(c).leafCnt;
            if(leafCnt == 0){
                leafCnt = 1;
                isLeaf = true;
            }
            int afterCnt = leafCnt;

            int curIdx = idx;
            int curParent = parent;
            while(curParent != -1){
                treeNodes.get(curParent).leafCnt += afterCnt - beforeCnt;
                curIdx = curParent;
                curParent = treeNodes.get(curIdx).parent;
            }
        };

        void removeNode() {
            treeNodes.get(parent).removeChildren(idx);
        }
        boolean isRoot(){return parent == -1;};
    }
}
