package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.09.24
 */
public class Medium_79 {
    /**
     * 单词搜索
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/word-search/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * </p>
     *
     * <p>
     * 示例：
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     * </p>
     *
     * <p>
     * 解答：回溯，看作二叉树的升级版--四叉树
     * 遍历 board，找到第一个匹配的字符，从当前位置不断向四个方向上尝试，检查边界条件和重复使用，使用 used 数组记录当前元素是否使用过，
     * 边界不能超过数组的大小，递归终止条件是找到字符串最后的字符。
     * </p>
     *
     * <p>
     * 时间复杂度：?
     * 空间复杂度：O(M*N)
     * </p>
     */

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";
        boolean exist = new Medium_79().exist(board, word);
        System.out.println(exist); // true
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0] == null || word == null) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] used) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index) || used[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        used[i][j] = true;
        boolean result = dfs(board, word, i - 1, j, index + 1, used)
                || dfs(board, word, i + 1, j, index + 1, used)
                || dfs(board, word, i, j - 1, index + 1, used)
                || dfs(board, word, i, j + 1, index + 1, used);
        used[i][j] = false;
        return result;
    }

}
