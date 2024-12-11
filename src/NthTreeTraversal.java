package src;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
public class NthTreeTraversal {
    class Node {
        int val;
        List<Node> children;
    }


    // N 叉树的遍历框架
    void DFS(Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            DFS(child);
        }
    }

    void BFS(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        // 记录当前遍历到的层数（根节点视为第 1 层）
        int depth = 1;
    
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                // 访问 cur 节点，同时知道它所在的层数
                System.out.println("depth = " + depth + ", val = " + cur.val);
    
                for (Node child : cur.children) {
                    q.offer(child);
                }
            }
            depth++;
        }
    }

}
