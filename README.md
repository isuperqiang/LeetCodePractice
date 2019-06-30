### LeetCode 算法练习

编程能力就像任何其他技能一样，也是一个可以通过`刻意练习`大大提高的。

大多数经典面试题目都有多种解决方案。 为了达到最佳的练习效果，我们强烈建议您至少将此清单里的题目练习两遍，如果可以的话，三遍会更好。

在第二遍练习时，你可能会发现一些新的技巧或新的方法。 到第三遍的时候，你会发现你的代码要比第一次提交时更加简洁。 如果你达到了这样的效果，那么恭喜你，你已经掌握了正确的练习方法！

**记住：** 刻意练习并不意味着寻找答案并记住它，这种练习方法不是长久之计。 在没有参考答案情况下，越能自主解决问题，才越能提高自身能力。

----

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

争取每日做一道算法题，训练自己的逻辑思维，掌握算法及数据结构，并提高自己的的编程能力，加油！

#### 解题技巧

1. 数组

2. 链表

链表问题相对容易掌握。 不要忘记"双指针解法"，它不仅适用于数组问题，而且还适用于链表问题。

另一种大大简化链接列表问题的方法是"Dummy node" 节点技巧，所谓Dummy Node其实就是带头节点的指针。
