package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.05.23
 */
public class Easy_437 {
    /**
     * 路径总和 III
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/path-sum-iii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * 找出路径和等于给定数值的路径总数。
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     * </p>
     *
     * <p>
     * 示例：
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * <p>
     * 返回 3。和等于 8 的路径有:
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     * </p>
     *
     * <p>
     * 解答：
     * 两次递归。pathSum 返回以当前节点为根的树中，路径和为目标值的路径总数；count 返回以当前节点为根的树中，有多少以该节点为开头，
     * 路径和为目标值的路径总数。
     * </p>
     *
     * <p>
     * 时间复杂度：
     * 空间复杂度：
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(11);
        int i = pathSum(root, 8);
        System.out.println(i);
    }

    private static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int count(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int count = sum == 0 ? 1 : 0;
        return count + count(root.left, sum) + count(root.right, sum);
    }
}
