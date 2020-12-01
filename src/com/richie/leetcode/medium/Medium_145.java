package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2020.10.20
 */
public class Medium_145 {
    /**
     * 二叉树后序遍历
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树，返回它的后序遍历。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,null,2,3]
     * //   1
     * //    \
     * //     2
     * //    /
     * //   3
     * 输出: [3,2,1]
     * </p>
     *
     * <p>
     * 解答：
     * - 递归：递归终止条件 root 为空，递归左子树，递归右子树，打印当前节点。
     * - 迭代：和前序类似，前序中左右，后序左右中，在前序遍历的基础上修改即可。
     * </p>
     *
     * <p>
     * - 递归：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * - 迭代：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = new Medium_145().postorderTraversal(root);
        System.out.println(result);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.addFirst(top.val);
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        postorderTraversalRecursive(root, result);
        return result;
    }

    private void postorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursive(root.left, result);
        postorderTraversalRecursive(root.right, result);
        result.add(root.val);
    }
}
