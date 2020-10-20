package com.richie.leetcode;

import java.util.*;

/**
 * @author Richie on 2020.04.03
 */
public class TestCase {
    public static final String TAG = "1";

    public static void main(String[] args) {
        //       int[] a = new int[]{4,1,2,1,2};
        //        int i = singleNumber(a);
        //        System.out.println(i);

        // 输入:
        //nums1 = [1,2,3,0,0,0], m = 3
        //nums2 = [2,5,6],       n = 3
        //
        //输出: [1,2,2,3,5,6]
        //        int[] nums1 = {1, 2, 3, 0, 0, 0};
        //        int[] nums2 = {2, 5, 6};
        //        merge(nums1, 3, nums2, 3);
        //        System.out.println(Arrays.toString(nums1));

        //        int i = superEggDrop(1, 2);
        //        System.out.println(i);

        //        TreeNode root = new TreeNode(3);
        //        root.left = new TreeNode(9);
        //        root.right = new TreeNode(20);
        //        root.right.left = new TreeNode(15);
        //        root.right.right = new TreeNode(7);
        //        bfs(root);

        // 以下代码输出什么
        //        Map<Short, String> map = new HashMap<>();
        //        for (short i = 0; i < 100; i++) {
        //            map.put(i, String.valueOf(i));
        //            // short 和 int 计算，结果总是 int，原因是 short 首先自动被转型为 int
        //            map.remove(i - 1);
        //        }
        //        System.out.println(map.size()); // 100

        //        int fib = fib3(10);
        //        System.out.println(fib);


        //        int i = maxValue(4, 3, new int[]{2, 1, 3}, new int[]{4, 2, 3});
        //        System.out.println(i); // 9

        //        int[] nums = {1,2,3,4,5};
        //        int i = binarySearch(nums, 4);
        //        int[] nums2 = {1, 2, 2, 2, 4, 5};
        //        int i = binarySearchRightBound(nums2, 2);
        //        System.out.println(i);

        //        ListNode head = new ListNode(3);
        //        head.next = new ListNode(2);
        //        head.next.next = new ListNode(0);
        //        head.next.next.next = new ListNode(4);
        //        head.next.next.next = head.next;
        //        boolean b = hasCycle(head);
        //        System.out.println(b);

        //        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>(16, 0.75f, true) {
        //            @Override
        //            protected boolean removeEldestEntry(Map.Entry eldest) {
        //                return size() > 4;
        //            }
        //        };
        //        map.put(1, "a");
        //        map.put(2, "b");
        //        map.get(1);
        //        map.put(3, "c");
        //        map.get(2);
        //        map.put(4, "d");
        //        map.put(5, "e");
        //        map.get(3);
        //        travelMap(map);

        //        LruCache<Integer, String> lruCache = new LruCache<>(2);
        //        lruCache.put(1, "a");
        //        lruCache.put(2, "b");
        //        lruCache.get(1);
        //        lruCache.put(3, "c");
        //        lruCache.get(1);
        //        lruCache.put(4, "d");
        //        String travel = lruCache.travel();
        //        System.out.println(travel);
        //        int stringContains = isStringContains("goodgoogle", "google");
        //        System.out.println(stringContains);

        //        int[] nums = {1, 2, 3};
        //        List<List<Integer>> permute = new TestCase().permute(nums);
        //        System.out.println(permute);

        //        int i = new TestCase().backPack(10, new int[]{3, 4, 8, 5});
        //        System.out.println(i); // 9

        // m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4], 9
        //        int i1 = new TestCase().backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4});
        //        System.out.println(i1); // 9

        // 子集
        //        List<List<Integer>> subsets = new TestCase().subsets(new int[]{1, 2, 3});
        //        System.out.println(subsets);


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> result = new ArrayList<>();
        new TestCase().preorderTraversal2(root, result);
        System.out.println(result);

    }

    //                 3
    //                / \
    //               9  20
    //                  /  \
    //                 15   7
    public void preorderTraversal2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.removeLast();
            result.add(top.val);
            if (top.right != null) {
                stack.addLast(top.right);
            }
            if (top.left != null) {
                stack.addLast(top.left);
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, Deque<Integer> path, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(result, nums, path, i + 1);
            path.removeLast();
        }
    }


    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0 || m <= 0) {
            return 0;
        }
        //dp[i][j] 代表 前 i 个物品, 能不能填满容量为 j 的背包
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[A.length][i]) {
                return i;
            }
        }
        return 0;
    }

    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        if (m <= 0 || A == null || A.length <= 0 || V == null || V.length != A.length) {
            return 0;
        }
        // dp[i][j] 前 i 个物品装进容量为 j 的背包，最大价值
        int[][] dp = new int[A.length + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[A.length][m];
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrace(result, new LinkedList<>(), nums);
        return result;
    }


    private void backtrace(List<List<Integer>> result, Deque<Integer> path, int[] nums) {
        if (nums.length == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //        1 2 3
        for (int i = 0; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrace(result, path, nums);
            path.removeLast();
        }
    }


    private static class LruCache<K, V> {
        private static class Node<K, V> {
            K k;
            V v;

            Node(K k, V v) {
                this.k = k;
                this.v = v;
            }
        }

        private HashMap<K, Node<K, V>> map;
        private LinkedList<Node<K, V>> linkedList;
        private int capacity;

        public LruCache(int capacity) {
            map = new HashMap<>();
            linkedList = new LinkedList<>();
            this.capacity = capacity;
        }

        public void put(K k, V v) {
            Node<K, V> node = new Node<>(k, v);
            if (map.containsKey(k)) {
                // 放入 map
                Node<K, V> old = map.put(k, node);
                // 删除旧元素
                linkedList.remove(old);
                // 插入新元素到尾部
            } else {
                if (linkedList.size() == capacity) {
                    Node<K, V> first = linkedList.removeFirst();
                    map.remove(first.k);
                }
                // 放入 map
                map.put(k, node);
                // 放入 list 尾部
            }
            linkedList.addLast(node);
        }

        public V get(K k) {
            if (map.containsKey(k)) {
                Node<K, V> node = map.get(k);
                linkedList.remove(node);
                linkedList.addLast(node);
                return node.v;
            }
            return null;
        }

        public String travel() {
            Iterator<Node<K, V>> iterator = linkedList.iterator();
            StringBuilder sb = new StringBuilder();
            while (iterator.hasNext()) {
                Node<K, V> next = iterator.next();
                sb.append("[").append(next.k).append(", ").append(next.v).append("],");
            }
            return sb.toString();
        }
    }


    private static <K, V> void travelMap(Map<K, V> map) {
        if (map == null) {
            return;
        }
        Set<Map.Entry<K, V>> entries = map.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entries) {
            sb.append("[").append(entry.getKey()).append(":").append(entry.getValue()).append("], ");
        }
        System.out.println(sb.toString());
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static int binarySearch(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearchLeftBound(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private static int binarySearchRightBound(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    // 0-1 背包问题
    //    给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]，
    //    现在让你用这个背包装物品，最多能装的价值是多少？
    //    N = 3, W = 4
    //    wt = [2, 1, 3]
    //    val = [4, 2, 3]
    //    output: 6
    private static int maxValue(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        // dp[i,w] 表示装入前 i 个物品，背包重量为 j 时，最大价值是 dp[i,j]
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < wt[i - 1]) {
                    // 不装
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装或不装，择优
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[N][W];
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fib2(int n) {
        int[] mem = new int[n + 1];
        return fib2Mem(mem, n);
    }

    private static int fib2Mem(int[] mem, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (mem[n] > 0) {
            return mem[n];
        }
        mem[n] = fib2Mem(mem, n - 1) + fib2Mem(mem, n - 2);
        return mem[n];
    }

    private static int fib3(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    private static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            System.out.println("node:" + treeNode);
        }
    }

    public static int superEggDrop(int K, int N) {
        for (int i = K; i < N; i++) {
            int a = (int) Math.pow(2, i);
            if (a > N) {
                return i;
            }
        }
        return 0;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length < m || nums2.length < n) {
            return;
        }
        int pos = m + n - 1;
        m--;
        n--;
        while (n >= 0 && m >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[pos--] = nums1[m--];
            } else {
                nums1[pos--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[pos--] = nums2[n--];
        }
    }

    //输入: [4,1,2,1,2]
    //输出: 4
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }

}
