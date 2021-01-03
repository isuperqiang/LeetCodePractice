package com.richie.leetcode.offer;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2021.01.03
 */
public class Offer_32_3 {
    /**
     * 从上到下打印二叉树 III
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
     * </p>
     *
     * <p>
     * 示例：
     * 给定二叉树: [3,9,20,null,null,15,7],
     * //    3
     * //   / \
     * //  9  20
     * //    /  \
     * //   15   7
     * 返回其层次遍历结果：
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     * </p>
     *
     * <p>
     * 解答：
     * 在层次遍历的基础上，记录当前是正向还是逆向，遍历完当前层次，反转方向。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> ans = new Offer_32_3().levelOrder(root);
        System.out.println(ans);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> level;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        boolean even = false;
        while (!queue.isEmpty()) {
            level = new LinkedList<>();
            for (int i = 0, s = queue.size(); i < s; i++) {
                TreeNode head = queue.removeFirst();
                if (even) {
                    level.addFirst(head.val);
                } else {
                    level.addLast(head.val);
                }
                if (head.left != null) {
                    queue.addLast(head.left);
                }
                if (head.right != null) {
                    queue.addLast(head.right);
                }
            }
            even = !even;
            ans.add(level);
        }
        return ans;
    }
}
