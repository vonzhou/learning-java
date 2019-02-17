package oj.leetcode;

import java.util.*;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Created by vonzhou on 2019/2/17.
 */
public class LowestCommonAncestorOfBinaryTree {

    /**
     * 引入 parent pointer
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 保存节点的父节点
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        // stack 辅助树的遍历
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        // 一直要找到p,q的父节点
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // 如果q的某个祖先节点出现在了 p 的祖先节点中,那么就找到了 LCA
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
