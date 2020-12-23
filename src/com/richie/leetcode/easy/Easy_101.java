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
     * 链接：https://leetcode-cn.com/problems/symmetric-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，检查它是否是镜像对称的。
     * </p>
     *
     * <p>
     * 示例：
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * //       1
     * //    /    \
     * //   2      2
     * //  / \    / \
     * // 3   4  4   3
     * </p>
     *
     * <p>
     * 解答：
     * - 递归法：如果同时满足下面的条件，那么两个树互为镜像：它们的根节点具有相同的值；每个树的左子树都与另一个树的右子树镜像对称。
     * - 迭代法：类似广度优先遍历树，但要用队列保存双份的节点。每次提取两个节点并比较它们的值。然后将两个节点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称时，算法结束。
     * </p>
     *
     * <p>
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(N)
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
        boolean symmetric = new Easy_101().isSymmetric(root);
        System.out.println(symmetric);
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    // 递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
