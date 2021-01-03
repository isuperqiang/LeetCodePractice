package com.richie.leetcode.offer;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2021.01.03
 */
public class Offer_32_1 {
    /**
     * 从上到下打印二叉树
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
     * 返回：
     * [3,9,20,15,7]
     * </p>
     *
     * <p>
     * 解答：
     * 二叉数的层次遍历
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
        int[] ans = new Offer_32_1().levelOrder(root);
        System.out.println(Arrays.toString(ans));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.removeFirst();
            result.add(treeNode.val);
            if (treeNode.left != null) {
                queue.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.addLast(treeNode.right);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0, length = ans.length; i < length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
