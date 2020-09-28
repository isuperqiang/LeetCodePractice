package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Richie on 2020.09.29
 */
public class Medium_98 {
    /**
     * 验证二叉搜索树
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/validate-binary-search-tree/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * </p>
     *
     * <p>
     * 示例：
     * 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     * </p>
     *
     * <p>
     * 解答：
     * - 递归：根据二叉搜索树的定义，确定递归函数，参数包含上下边界，访问左子树时，上边界为根节点值，方位右子树时，下边界为根节点值；
     * - 中序遍历：左中右遍历二叉搜索树，得到的一定时递增序列；如果不是，就不是二叉搜索树；
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean validBST = new Medium_98().isValidBST(root);
        System.out.println(validBST); // true
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        long prev = Long.MIN_VALUE;
        Deque<TreeNode> q = new ArrayDeque<>();
        while (q.size() > 0 || root != null) {
            while (root != null) {
                q.push(root);
                root = root.left;
            }
            root = q.pop();
            if (root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBSTInner(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTInner(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return isValidBSTInner(root.left, min, root.val) && isValidBSTInner(root.right, root.val, max);
    }

}
