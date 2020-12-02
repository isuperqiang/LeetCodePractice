package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.*;

/**
 * @author Richie on 2020.05.23
 */
public class Medium_113 {
    /**
     * 路径总和 II
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/path-sum-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * </p>
     *
     * <p>
     * 示例：
     * 给定如下二叉树，以及目标和 sum = 22，
     * //              5
     * //             / \
     * //            4   8
     * //           /   / \
     * //          11  13  4
     * //         /  \    / \
     * //        7    2  5   1
     * 返回：
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     * </p>
     *
     * <p>
     * 解答：回溯
     * 从根节点开始遍历，每次用目标和减去当前值，使用栈记录走过的路径。如果到达叶子节点且路径总和满足条件，则把路径添加到结果集。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> lists = new Medium_113().pathSum(root, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(root, sum, result, path);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> path) {
        path.addLast(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum - root.val, result, path);
            path.removeLast();
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, result, path);
            path.removeLast();
        }
    }
}
