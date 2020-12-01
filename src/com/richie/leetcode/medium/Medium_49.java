package com.richie.leetcode.medium;

import java.util.*;

/**
 * @author Richie on 2020.09.21
 */
public class Medium_49 {
    /**
     * 字母异位词分组
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/group-anagrams/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * </p>
     *
     * <p>
     * 解答：
     * 一个大前提：两个字符串是字母异位，当且仅当排序字符串相等时。
     * 维护一个映射 {String -> List}，其中每个键 K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 K。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N*K*logK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度
     * 空间复杂度：O(N*K)
     * </p>
     */

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists); // [[eat, tea, ate], [bat], [tan, nat]]
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> strings = map.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
                map.put(key, strings);
            }
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }

}
