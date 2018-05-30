### LeetCode 算法练习

题目来自：[LeetCode 中国](https://leetcode-cn.com/)，难度分为三等，简单、中等和困难。
每道题目有描述和解答，例如：

```
public class E_001 {

    /**
     * 删除排序数组中的重复项
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
     * </p>
     *
     * <p>
     * 描述：给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * </p>
     *
     * <p>
     * 解答：采用快慢指针记录遍历的坐标，开始时两个指针都指向第一个数字。如果两个指针指向的数字相同，那么快指针向前走一步；
     * 如果不同，那么两个指针都向前走一步。这样当快指针走完整个数组后，慢指针当前的坐标加 1 就是数组中不同数字的个数。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int len = removeDuplicates(nums);
        System.out.println("len:" + len);
        // 输出 2
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
```