package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2019.06.23
 */
public class Easy_108 {
    /**
     * 将有序数组转换为二叉搜索树
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
     * </p>
     *
     * <p>
     * 描述：将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
     * </p>
     *
     * <p>
     * 示例：
     * 给定有序数组: [-10,-3,0,5,9],
     * <p>
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     * </p>
     *
     * <p>
     * 解答：以数组的中间元素为根节点，将数组分为左右两部分，用递归的方法对两个子数组分别构建左右子树。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return toBst(nums, 0, nums.length - 1);
    }

    private static TreeNode toBst(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBst(nums, l, mid - 1);
        root.right = toBst(nums, mid + 1, r);
        return root;
    }

}
