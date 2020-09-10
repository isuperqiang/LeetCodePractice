package com.richie.leetcode.medium;

import java.util.*;

/**
 * @author Richie on 2020.09.10
 */
public class Medium_17 {
    /**
     * 电话号码的字母组合
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * </p>
     *
     * <p>
     * 示例：
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     * </p>
     *
     * <p>
     * 解答：
     * - 回溯（DFS）
     * 使用哈希表存储每个数字对应的字母，维护一个字符串表示当前字母排列，当字符串长度等于数字长度时，将其添加到结果集中。每次从哈希表取一位数字的
     * 对应字母组合，按顺序将字母添加到字母排列后面，继续遍历下一个字母。问题可以转化成从树的根节点到空节点有多少路径。
     * - 队列（BFS）
     * 先将输入的 digits 中第一个数字对应的每个字母入队，然后将出队的元素与第二个数字对应的每个字母组合后入队...直到遍历到 digits 的结尾。
     * 最后队列中的元素就是所求结果。
     *
     * </p>
     *
     * <p>
     * - 回溯：
     * 时间复杂度：O(3^m * 4^n)，其中 m 是输入中对应 3 个字母的数字个数（包括数字 22、33、44、55、66、88），n 是输入中对应 4 个字母的数字个数（包括数字 77、99）。
     * 空间复杂度：O(m+n)，map 视为常量。
     * - 队列：
     * 时间复杂度：O(3^m * 4^n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        String s = "23";
        List<String> strings = letterCombinations2(s);
        System.out.println(strings);
    }

    private static List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        List<String> combinations = new ArrayList<>();
        combinations.add("");
        for (int i = 0, len = digits.length(); i < len; i++) {
            String letter = phoneMap.get(digits.charAt(i));
            for (int j = 0, size = combinations.size(); j < size; j++) {
                String remove = combinations.remove(0);
                for (int k = 0; k < letter.length(); k++) {
                    combinations.add(remove + letter.charAt(k));
                }
            }
        }
        return combinations;
    }

    private static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        List<String> combinations = new ArrayList<>();
        backtrace(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    private static void backtrace(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder temp) {
        if (index == digits.length()) {
            combinations.add(temp.toString());
        } else {
            char number = digits.charAt(index);
            String letter = phoneMap.get(number);
            for (int i = 0, len = letter.length(); i < len; i++) {
                temp.append(letter.charAt(i));
                backtrace(combinations, phoneMap, digits, index + 1, temp);
                temp.deleteCharAt(index);
            }
        }
    }

}
