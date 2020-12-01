package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richie on 2020.09.29
 */
public class Medium_105 {
    /**
     * 从前序与中序遍历序列构造二叉树
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * </p>
     *
     * <p>
     * 描述：
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意：
     * 你可以假设树中没有重复的元素。
     * </p>
     *
     * <p>
     * 示例：
     * 给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * </p>
     *
     * <p>
     * 解答：
     * - 递归
     * 前序遍历的第一个元素一定是根节点，用 map 映射中序遍历的元素及其位置。在中序序列中找到根节点位置，此位置将中序序列一分为二，分别用两个指针
     * 指向前序序列和中序序列的首尾位置，注意指针包括左右边界。递归地构造左子树和右子树，把大问题分解成小问题，分而治之。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Medium_105().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0 || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeInternal(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeInternal(int[] preorder, int preLeft, int preRight, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = map.get(pivot);
        root.left = buildTreeInternal(preorder, preLeft + 1, preLeft + pivotIndex - inLeft, inLeft, pivotIndex - 1, map);
        root.right = buildTreeInternal(preorder, preLeft + pivotIndex - inLeft + 1, preRight, pivotIndex + 1, inRight, map);
        return root;
    }

}
