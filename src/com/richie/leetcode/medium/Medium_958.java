package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Richie on 2020.12.01
 */
public class Medium_958 {
    /**
     * 二叉树的完全性检验
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，确定它是否是一个完全二叉树。
     * 百度百科中对完全二叉树的定义如下：
     * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
     * （注：第 h 层可能包含 1~2h 个节点。）
     * </p>
     *
     * <p>
     * 示例：
     * 输入：[1,2,3,4,5,6]
     * //        1
     * //     /    \
     * //    2     3
     * //   / \   /
     * //  4   5 6
     * 输出：true
     * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
     * 输入：[1,2,3,4,5,6]
     * 输出：true
     * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
     *
     * </p>
     *
     * <p>
     * 解答：
     * 层次遍历二叉树的节点（包括空节点），当且仅当存在两个相邻节点：前一个为null，后一个不为null时，才不是完全二叉树。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        boolean completeTree = new Medium_958().isCompleteTree(root);
        System.out.println(completeTree);
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode head = queue.remove();
            if (head == null) {
                flag = true;
                continue;
            }
            if (flag) {
                return false;
            }
            queue.add(head.left);
            queue.add(head.right);
        }
        return true;
    }
}
