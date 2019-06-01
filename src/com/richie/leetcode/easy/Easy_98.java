package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

/**
 * @author richie on 2018.06.27
 */
public class Easy_98 {
    /**
     * 验证二叉搜索树
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/validate-binary-search-tree/description/
     * </p>
     *
     * <p>
     * 描述：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * </p>
     *
     * <p>
     * 解答：可以利用它本身的性质来做，即左<根<右，也可以通过利用中序遍历结果为有序数列来做。
     * 我们利用其本身性质，初始化时带入系统最大值和最小值，在递归过程中换成它们自己的节点值，用long代替int就是为了包括int的边界条件。
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(1);
        root.left = l1;
        TreeNode r1 = new TreeNode(4);
        TreeNode r21 = new TreeNode(3);
        TreeNode r22 = new TreeNode(6);
        r1.left = r21;
        r1.right = r22;
        root.right = r1;
        System.out.println(isValidBST(root));

        /*
        * 输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
        * */
    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean valid(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }
}
