package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.10.28
 */
public class Medium_701 {
    /**
     * 二叉搜索树中的插入操作
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
     * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：root = [4,2,7,1,3], val = 5
     * //      4
     * //     / \
     * //    2   7
     * //  /  \
     * // 1    3
     * 输出：[4,2,7,1,3,5]
     * //       4
     * //     /   \
     * //    2     7
     * //  /  \   /
     * // 1    3 5
     * </p>
     *
     * <p>
     * 解答：
     * - 递归
     * 如果 root 为空，创建新节点返回。否则，比较目标值和节点值的大小，从而决定在哪个子树中继续递归。
     * - 迭代
     * 判断目标值和节点值的关系，如果节点值大，就把目标值插入左子树，否则插入右子树。插入时判断子树是否为空，如果为空，则创建新节点插入，
     * 否则更新当前节点，继续下次迭代。
     * </p>
     *
     * <p>
     * - 递归：
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(n)
     * - 迭代：
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        TreeNode treeNode = new Medium_701().insertIntoBST(root, 5);
        System.out.println(treeNode);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }
        return root;
    }
}
