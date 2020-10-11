package com.richie.leetcode.medium;

import com.richie.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richie on 2020.10.11
 */
public class Medium_106 {
    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     * </p>
     *
     * <p>
     * 描述：
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * </p>
     *
     * <p>
     * 示例：
     * 例如，给出
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
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
     * 后续遍历的最后一个元素一定是根节点。同 105 题
     * </p>
     *
     * <p>
     * 时间复杂度：
     * 空间复杂度：
     * </p>
     */

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = new Medium_106().buildTree(inorder, postorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length <= 0 || inorder == null || postorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeInternal(postorder, 0, postorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeInternal(int[] postorder, int postLeft, int postRight, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        int pivot = postorder[postRight];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = map.get(pivot);
        root.left = buildTreeInternal(postorder, postLeft, postLeft + pivotIndex - inLeft - 1, inLeft, pivotIndex - 1, map);
        root.right = buildTreeInternal(postorder, postLeft + pivotIndex - inLeft, postRight - 1, pivotIndex + 1, inRight, map);
        return root;
    }

}
