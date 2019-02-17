package oj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Created by vonzhou on 2019/2/17.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * AC
     * DFS, 深度优先,遍历到对应层的时候把对应元素维护到结果集中
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if (curr == null) return;

        if (sol.size() <= level) {
            // 开辟保存新一层的结果
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> listOfThisLevel = sol.get(level);
        // 偶数层的话从左到右, 奇数层从右到左
        if (level % 2 == 0)
            listOfThisLevel.add(curr.val);
        else listOfThisLevel.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    /**
     * AC
     * 使用2个栈,每层的元素入同一个栈
     * BFS,广度优先
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        TreeNode p = root;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (p == null)
            return res;

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {

            List<Integer> tmp = new ArrayList<Integer>();
            while (!s1.isEmpty()) {
                p = s1.pop();
                tmp.add(p.val);
                if (p.left != null)
                    s2.push(p.left);
                if (p.right != null)
                    s2.push(p.right);
            }
            res.add(tmp);

            tmp = new ArrayList<Integer>();
            while (!s2.isEmpty()) {
                p = s2.pop();
                tmp.add(p.val);
                // 奇数层,从右向左,所以先遍历右孩子
                if (p.right != null)
                    s1.push(p.right);
                if (p.left != null)
                    s1.push(p.left);
            }

            if (!tmp.isEmpty())
                res.add(tmp);
        }
        return res;
    }
}
