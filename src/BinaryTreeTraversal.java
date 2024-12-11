package src;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversal {
    //二叉树
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    //多叉树
    class Node {
        int val;
        List<Node> children;
    }

    //深度优先
    void DFS(TreeNode root) {
        if(root == null) {
            return;
        }
        DFS(root.left);
        DFS(root.right);
    }

    //广度优先初版
    void BFS_1(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            // 访问 cur 节点
            System.out.println(cur.val);
    
            // 把 cur 的左右子节点加入队列
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }

    //广度优先优化版
    void BFS_2(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 访问 cur 节点，同时知道它所在的层数
                System.out.println("depth = " + depth + ", val = " + cur.val);
    
                // 把 cur 的左右子节点加入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
    }
}
