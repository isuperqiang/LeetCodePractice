package com.richie.leetcode.easy;

import com.richie.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * @author richie on 2019.06.07
 */
public class Easy_226 {
    /**
     * 翻转二叉树
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/invert-binary-tree/
     * </p>
     *
     * <p>
     * 描述：翻转一棵二叉树
     * </p>
     *
     * <p>
     * 示例：
     * 输入:
     * 4
     * 2     7
     * 1  3  6  9
     * 输出:
     * 4
     * 7     2
     * 9  6  3  1
     * </p>
     *
     * <p>
     * 解答：
     * - 递归法：翻转一个二叉树，就是把根节点的左子树翻转一下，同样的把右子树翻转一下，再交换左右子树就可以了。
     * - 迭代法：类似广度优先遍历的方式，使用队列存储尚未交换的节点，每次从队列取出一个结点，交互其左右子结点，直到队列为空。
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        root.left = treeNode2;
        TreeNode treeNode7 = new TreeNode(7);
        root.right = treeNode7;
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(3);
        treeNode7.left = new TreeNode(6);
        treeNode7.right = new TreeNode(9);

        invertTreeRecursively(root);
        System.out.println(root);
    }

    private static TreeNode invertTreeRecursively(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeRecursively(root.left);
        invertTreeRecursively(root.right);
        return root;
    }

    private static TreeNode invertTreeIteratively(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.isEmpty()) {
            TreeNode current = list.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                list.add(current.left);
            }
            if (current.right != null) {
                list.add(current.right);
            }
        }
        return root;
    }

}
