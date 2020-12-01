package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.03.26
 */
public class easy_1160 {
    /**
     * 拼写单词
     * <p>
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
     * </p>
     *
     * <p>
     * 描述：
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
     * 输出：6
     * 解释：
     * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     * </p>
     *
     * <p>
     * 解答：
     * 使用数组记录 chars 中每个字母出现的次数，同样地，遍历 words 记录单词中每个字母出现的次数，然后和 chars 中对应的字母次数做比较。
     * 如果某个字母在 chars 中出现的次数大于等于在单词中出现的次数，就认为是掌握了这个单词。
     * 使用 Map 的时间大于数组，因为存在 rehash 和 box/unbox 操作。
     * </p>
     *
     * <p>
     * 时间复杂度：
     * 空间复杂度：
     * </p>
     */

    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        int result = countCharacters(words, chars);
        System.out.println("result:" + result); // 10
    }

    private static int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
            return 0;
        }
        char[] charsArray = chars.toCharArray();
        int[] charsCount = new int[26];
        for (char c : charsArray) {
            charsCount[c - 'a'] += 1;
        }
        int result = 0;
        int[] wordCount;
        for (String word : words) {
            wordCount = new int[26];
            char[] wordArray = word.toCharArray();
            for (char c : wordArray) {
                wordCount[c - 'a'] += 1;
            }
            boolean isHit = true;
            for (int i = 0; i < 26; i++) {
                if (charsCount[i] < wordCount[i]) {
                    isHit = false;
                    break;
                }
            }
            if (isHit) {
                result += word.length();
            }
        }
        return result;
    }
}
