package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

/**
 * @author Richie on 2020.10.12
 */
public class Medium_114 {
    /**
     * 二叉树展开为链表
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，原地将它展开为一个单链表。
     * </p>
     *
     * <p>
     * 示例：
     * 例如，给定二叉树
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * 将其展开为：
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * </p>
     *
     * <p>
     * 解答：
     * 展开顺序就是前序优先遍历。
     * - 将左子树插入右子树的位置，左子树设置为 null
     * - 将原来的右子树放到左子树的最右节点
     * - 考虑新的右子树的根节点，直到为 null
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new Medium_114().flatten(root);
        System.out.println(root);
    }

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode lr = root.left;
                while (lr.right != null) {
                    lr = lr.right;
                }
                lr.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
