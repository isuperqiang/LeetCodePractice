package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author richie on 2019.05.21
 */
public class Easy_101 {
    /**
     * 对称二叉树
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/symmetric-tree/
     * </p>
     *
     * <p>
     * 描述：给定一个二叉树，检查它是否是镜像对称的。
     * </p>
     *
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 1
     * /   \
     * 2    2
     * / \  / \
     * 3 4 4  3
     * </p>
     *
     * <p>
     * 解答：
     * - 递归法：如果同时满足下面的条件，两个树互为镜像：它们的两个根结点具有相同的值；每个树的右子树都与另一个树的左子树镜像对称。
     * - 迭代法：类似广度优先遍历，但要把队列存的值 Double 一下。每次提取两个结点并比较它们的值。然后将两个结点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，算法结束。
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean symmetric = isSymmetric2(root);
        System.out.println(symmetric);
    }

    // 迭代法
    private static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (q.size() > 0) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    // 递归法
    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return false;
    }
}
