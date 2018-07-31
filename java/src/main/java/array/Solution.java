package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

import node.ListNode;

/**
 * <a href="https://leetcode.com/problemset/all/">LeetCode</a>
 *
 * @author liming
 * @version [版本号, 六月 27, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Solution
{
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x轴共同构成的容器可以容纳最多的水。
     *
     * @param nums
     * @return
     */
    public int maxArea(int[] nums)
    {
        int maxarea = 0, l = 0, r = nums.length - 1;
        while (l < r)
        {
            int area = (r - l) * Math.min(nums[l], nums[r]);
            maxarea = Math.max(maxarea, area);
            if (nums[l] < nums[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return maxarea;
    }

    /**
     * 柱状图中最大的矩形
     * 同接雨水
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] height)
    {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++)
        {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()])
            {
                s.push(i);
            }
            else
            {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * <p>
     * 双向指针法，start 在前，end在后
     * 时间复杂度O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[][] threeSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        List<int[]> rstList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++)
        {
            int l = i + 1, r = nums.length - 1;
            while (l < r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target)
                {
                    int[] item = new int[] {nums[i], nums[l], nums[r]};
                    if (!containArray(rstList, item))
                    {
                        rstList.add(item);
                    }
                    l++;
                }
                else if (sum < target)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        int[][] rst = new int[rstList.size()][3];
        return rstList.toArray(rst);
    }

    private boolean containArray(List<int[]> list, int[] array)
    {
        for (int[] k : list)
        {
            if (Arrays.equals(array, k))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 思路：双指针，慢指针在左，快指针在右边，比较两个数大小。
     * 如果不同将慢指针前面的数替换为慢指针指向的数据，并且两个指针同时移动一位。
     * 如果相同，快指正向前移动一位
     * 最後快慢指針指向的位置就是結尾位置
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums)
    {
        int left = 0, right = 1;
        for (; right < nums.length; )
        {
            if (nums[left] < nums[right])
            {
                nums[left + 1] = nums[right];
                left++;
                right++;
            }
            else
            {
                right++;
            }
        }
        return left + 1;

    }

    /**
     * 搜索旋转排序数组
     * <p>
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     * @param nums
     * @return
     */
    public int rotatedArraySearch(int[] nums)
    {
        int idx = -1;
        return idx;
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * @param digits
     * @return
     */
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits)
    {
        List<String> rst = new ArrayList<>();
        combination("", 0, digits, rst);
        return rst;
    }

    private void combination(String prefix, int offset, String digts, List<String> rst)
    {
        if (offset > digts.length() - 1)
        {
            rst.add(prefix);
            return;
        }
        String letters = LETTERS[digts.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++)
        {
            combination(prefix + letters.charAt(i), offset + 1, digts, rst);
        }
    }

    public boolean canJump(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; )
        {
            //0跳跃，并且不是结尾
            if (nums[i] == 0 && i != nums.length - 1)
            {
                return false;
            }
            i += nums[i];
            if (i == nums.length - 1)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 示例:
     * <p>
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums)
    {
        if (nums.length <= 1)
            return 0;
        int curMax = 0; // to mark the last element in a level
        int level = 0, i = 0;
        while (i <= curMax)
        {
            int furthest = curMax; // to mark the last element in the next level
            for (; i <= curMax; i++)
            {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1)
                    return level + 1;
            }
            level++;
            curMax = furthest;
        }
        return -1; // if i < curMax, i can't move forward anymore (the last element in the array can't be reached)
    }

    /**
     * 46 全排列
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> rst = new ArrayList<>();
        return rst;
    }

    private void permuteRecursive(List<List<Integer>> rst, int[] nums, int offset, List<Integer> item)
    {
        if (item.size() == nums.length)
        {
            rst.add(item);
        }

    }

    /**
     * <<<<<<< Updated upstream
     * 5. Longest Palindromic Substring
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is
     * 1000.
     * <p>
     * Example 1:
     * <p>
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     * <p>
     * Input: "cbbd"
     * Output: "bb"
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s)
    {
        int len = s.length();
        int l = 0, e = 0, maxlen = 0;
        String longest = "";
        for (int i = 0; i < len; i++)
        {
            l = e = i;
            while (l >= 0 && e < len && s.charAt(l) == s.charAt(e))
            {
                l--;
                e++;
            }
            if (e - l - 1 > maxlen)
            {
                maxlen = e - l - 1;
                longest = s.substring(l + 1, e);

            }
        }
        return longest;
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        /*ListNode head = new ListNode(-1);
        ListNode tail = head;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>( (o1, o2) -> o1.val - o2.val);
        for(ListNode node : lists){
            while(node != null)
            {
                priorityQueue.add(node);
                node = node.next;
            }
        }
        while(priorityQueue.peek() != null){
            tail.next = priorityQueue.poll();
            tail = tail.next;
        }
        return head.next;*/

        ListNode head = new ListNode(-1);
        ListNode tail = head;
        PriorityQueue<ListNode> priorityQueue;
        priorityQueue = new PriorityQueue<ListNode>((o1, o2) ->
        {
            if (o1.val - o2.val > 0)
                return 1;
            else if (o1.val - o2.val < 0)
                return -1;
            else if (o1.next == null && o2.next != null)
                return 1;
            else if (o2.next == null && o1.next != null)
                return -1;
            return 0;
        }
        );
        for (ListNode node : lists)
        {
            while (node != null)
            {
                priorityQueue.add(node);
                node = node.next;
            }
        }

        while (priorityQueue.peek() != null)
        {
            tail.next = priorityQueue.poll();
            tail = tail.next;
        }

        return head.next;

    }

    /**
     * 62 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
     * <p>
     * 说明：m 和 n 的值均不超过 100。
     * <p>
     * 示例 1:
     * <p>
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * 示例 2:
     * <p>
     * 输入: m = 7, n = 3
     * 输出: 28
     */
    /*public List<String> uniquePaths(int m, int n)
    {
        List<String> paths = new ArrayList<>();
        oneStep(1, 1, m, n, paths, "");
        return paths;
    }

    private void oneStep(int hori, int vert, int m, int n, List<String> paths, String prePath)
    {
        if (hori == m && vert == n)
        {
            paths.add(prePath);
            return;
        }
        if (hori < m)
        {

            oneStep(hori + 1, vert, m, n, paths, prePath + "->right");
        }
        if (vert < n)
        {
            oneStep(hori, vert + 1, m, n, paths, prePath + "->down");
        }

    }*/

    /**
     * 63 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 说明：m 和 n 的值均不超过 100。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * DP 算法
     */
    public int uniquePathsWithObstaclesJr(int[][] obstacleGrid)
    {

        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        if (obstacleGrid[n - 1][m - 1] == 1)
        {
            return 0;
        }
        AtomicInteger pathNum = new AtomicInteger(0);
        oneStepWithObstacl(1, 1, m, n, obstacleGrid, pathNum);
        return pathNum.get();
    }

    private void oneStepWithObstacl(int hori, int vert, int m, int n, int[][] obstacleGrid, AtomicInteger pathNum)
    {
        if (hori == m && vert == n)
        {
            pathNum.getAndIncrement();
            return;
        }
        if (obstacleGrid[vert - 1][hori - 1] == 1)
        {
            return;
        }
        if (hori < m)
        {

            oneStepWithObstacl(hori + 1, vert, m, n, obstacleGrid, pathNum);
        }
        if (vert < n)
        {
            oneStepWithObstacl(hori, vert + 1, m, n, obstacleGrid, pathNum);
        }

    }

    // {0, 0, 0, 0},
    //    {0, 1, 0, 0},
    //    {0, 0, 0, 0}
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        //左上或者右下的点为1,无路可走
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][width - 1] == 1)
        {
            return 0;
        }
        for (int i = 0; i < obstacleGrid.length; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (obstacleGrid[i][j] == 1)
                {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }

        return dp[width - 1];
    }

    public int uniquePaths(int m, int n)
    {
        //最初的回溯算法，效率低下
       /* AtomicInteger pathNum = new AtomicInteger(0);
        oneStep(1, 1, m, n, pathNum);*/
        //思路:每个节点都是上方和左方两个点路径的和,
        //使用单个数组代表一行,累计每行点上的和.
        // 第一列上的点,路径都为1，只有一条线
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    private void oneStep(int hori, int vert, int m, int n, AtomicInteger pathNum)
    {
        if (hori == m && vert == n)
        {
            pathNum.getAndIncrement();
            return;
        }
        if (hori < m)
        {

            oneStep(hori + 1, vert, m, n, pathNum);
        }
        if (vert < n)
        {
            oneStep(hori, vert + 1, m, n, pathNum);
        }

    }

    /**
     * 最小路径和
     * 题目描述提示帮助提交记录社区讨论阅读解答
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     * <p>
     * DP算法是解决多阶段决策过程最优化问题的一种常用方法。
     * 多阶段决策过程（multistep decision
     * process）是指这样一类特殊的活动过程，过程可以按时间顺序分解成若干个相互联系的阶段，在每一个阶段都需要做出决策，全部过程的决策是一个决策序列。动态规划（dynamic
     * programming）算法是解决多阶段决策过程最优化问题的一种常用方法，难度比较大，技巧性也很强。利用动态规划算法，可以优雅而高效地解决很多贪婪算法或分治算法不能解决的问题。
     * 动态规划算法的基本思想是：将待求解的问题分解成若干个相互联系的子问题，先求解子问题，然后从这些子问题的解得到原问题的解；对于重复出现的子问题，只在第一次遇到的时候对它进行求解，并把答案保存起来，让以后再次遇到时直接引用答案，不必重新求解。
     * 动态规划算法将问题的解决方案视为一系列决策的结果，与贪婪算法不同的是，在贪婪算法中，每采用一次贪婪准则，便做出一个不可撤回的决策；
     * 而在动态规划算法中，还要考察每个最优决策序列中是否包含一个最优决策子序列，即问题是否具有最优子结构性质。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid)
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (i == 0)
                {
                    if (j == 0)
                    {
                        grid[i][j] = grid[i][j];
                    }
                    else
                    {
                        grid[i][j] = grid[i][j] + grid[i][j - 1];
                    }
                    continue;
                }
                if (j == 0)
                {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                    continue;
                }
                if (grid[i - 1][j] < grid[i][j - 1])
                {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
                else
                {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int up = 0, sum = 0;
        ListNode rst = null, first = null;
        while (l1 != null || l2 != null || up == 1)
        {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            sum = val1 + val2 + up;
            ListNode node = null;
            if (sum > 9)
            {
                up = 1;
                node = new ListNode(sum - 10);
            }
            else
            {
                up = 0;
                node = new ListNode(sum);
            }
            if (first == null)
            {
                rst = node;
                first = rst;
            }
            else
            {
                rst.next = node;
                rst = node;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return first;
    }

    public int calculateMinimumHP(int[][] dungeon)
    {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int i = dungeon.length - 1; i >= 0; i--)
        {
            for (int j = dungeon[0].length - 1; j >= 0; j--)
            {
                if (i == dungeon.length - 1 && j == dungeon[0].length - 1)
                {
                    dp[i][j] = (1 - dungeon[i][j] > 0) ? 1 - dungeon[i][j] : 1;
                    continue;
                }
                if (i == dungeon.length - 1)
                {
                    dp[i][j] = (dp[i][j + 1] - dungeon[i][j] > 0) ? dp[i][j + 1] - dungeon[i][j] : 1;
                }
                else if (j == dungeon[0].length - 1)
                {
                    dp[i][j] = (dp[i + 1][j] - dungeon[i][j] > 0) ? dp[i + 1][j] - dungeon[i][j] : 1;
                }
                else
                {
                    dp[i][j] = Math.min((dp[i][j + 1] - dungeon[i][j] > 0) ? dp[i][j + 1] - dungeon[i][j] : 1,
                        (dp[i + 1][j] - dungeon[i][j] > 0) ? dp[i + 1][j] - dungeon[i][j] : 1);
                }
            }
        }
        return dp[0][0];
    }
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string s, int numRows);
     * Example 1:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows)
    {
        int listSize = Math.min(s.length(), numRows);
        List<List<Character>> list = new ArrayList();
        for (int i = 0; i < listSize; i++)
        {
            list.add(new ArrayList());
        }

        int l = 0;
        boolean down = true;

        for (int idx = 0; idx < s.length(); idx++)
        {
            char c = s.charAt(idx);
            list.get(l).add(c);
            if (down)
            {
                if (l == numRows - 1)
                {
                    down = false;
                    if (l - 1 >= 0)
                    {
                        l--;
                    }
                }
                else
                {
                    l++;
                }
            }
            else
            {
                if (l == 0)
                {
                    down = true;
                    if (l + 1 < numRows)
                    {
                        l++;
                    }
                }
                else
                {
                    l--;
                }
            }
        }
        StringBuilder ss = new StringBuilder("");
        for (List<Character> lt : list)
        {
            for (Character c : lt)
            {
                ss.append(c);
            }
        }
        return ss.toString();
    }

    public boolean isInterleave(String s1, String s2, String s3)
    {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++)
        {
            for (int j = 0; j < s2.length() + 1; j++)
            {
                if (i == 0 && j == 0)
                {
                    dp[0][0] = true;
                }
                else if(i==0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
                else if(j==0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }
                else{
                    dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }

        }
        return dp[s1.length()][s2.length()];
    }


    public int trap(int[] height)
    {
        int l = 0, r = 0, m = 0, water = 0;

        while (r < height.length && l < height.length)
        {
            if (l + 1 < height.length && height[l + 1] >= height[l])
            {
                l++;
                r = l;
                continue;
            }
            if (l == r || height[r] < height[l])
            {
                r++;
                continue;
            }
            if (height[r] >= height[l])
            {
                water += (r - l - 1) * height[l];
                for (int i = l + 1; i < r; i++)
                {
                    water -= height[i];
                }
                l = r;
            }
        }

        if (r > l && height[r - 1] < height[l])
        {
            r = l + 2;
            for (int i = r; i < height.length; i++)
            {
                if (height[i] >= height[r])
                {
                    r = i;
                }
            }

            if (r < height.length)
            {
                water += (r - l - 1) * height[r];
                for (int i = l + 1; i < m; i++)
                {
                    water -= Math.min(height[i], height[l + 1]);
                }
            }
        }

        return water;
    }

    /**
     * 49. Group Anagrams
     * DescriptionHintsSubmissionsDiscussSolution
     * Given an array of strings, group anagrams together.
     * <p>
     * Example:
     * <p>
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * Note:
     * <p>
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs)
        {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String chs = String.valueOf(chars);
            if (!map.containsKey(chs))
            {
                map.put(chs, new ArrayList<>());
            }
            map.get(chs).add(s);
        }
        List<List<String>> rst = new ArrayList<>(map.values());
        return rst;

    }

    private Set<Integer> col = new HashSet<Integer>();

    private Set<Integer> diag1 = new HashSet<Integer>();

    private Set<Integer> diag2 = new HashSet<Integer>();

    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res, new ArrayList<String>(), 0, n);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> list, int row, int n)
    {
        if (row == n)
        {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++)
        {
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i))
                continue;

            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);

            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            dfs(res, list, row + 1, n);

            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval)
    {
        int start = 0, end = intervals.size() - 1;
        int startIndx = -1, endIndx = -1, startVal = newInterval.start, endVal = newInterval.end;
        while (end >= start)
        {
            int mid = (start + end) / 2;
            Interval interval = intervals.get(mid);
            int compare = inInterval(interval, newInterval.start);
            if (compare == 0)
            {
                startIndx = mid;
                startVal = interval.start;
                break;
            }

            if (compare == -1)
            {
                if (start == end)
                {
                    startIndx = start;
                    startVal = newInterval.start;
                    break;
                }
                else
                {
                    end = mid == start ? mid : mid - 1;
                }
            }
            else
            {
                if (start == end)
                {
                    startIndx = end + 1;
                    startVal = newInterval.start;
                    break;
                }
                else
                {
                    start = mid == end ? mid : mid + 1;
                }
            }
        }
        start = 0;
        end = intervals.size() - 1;
        while (end >= start)
        {
            int mid = (start + end) / 2;
            int compare = inInterval(intervals.get(mid), newInterval.end);
            if (compare == 0)
            {
                endIndx = mid;
                endVal = intervals.get(mid).end;
                break;
            }

            if (compare == -1)
            {
                if (start == end)
                {
                    endIndx = start - 1;
                    endVal = newInterval.end;
                    break;
                }
                else
                {
                    end = mid == start ? mid : mid - 1;
                }
            }
            else
            {
                if (start == end)
                {
                    endIndx = end;
                    endVal = newInterval.end;
                    break;
                }
                else
                {
                    start = mid == end ? mid : mid + 1;
                }
            }
        }

        for (int i = endIndx; i >= startIndx && i >= 0; i--)
        {
            intervals.remove(i);
        }
        Interval interval = new Interval(startVal, endVal);
        intervals.add(startIndx < 0 ? 0 : startIndx, interval);
        return intervals;
    }

    private int inInterval(Interval interval, int val)
    {
        if (interval.start <= val && interval.end >= val)
        {
            return 0;
        }
        if (interval.start > val)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

    static class Interval
    {
        int start;

        int end;

        Interval()
        {
            start = 0;
            end = 0;
        }

        Interval(int s, int e)
        {
            start = s;
            end = e;
        }
    }

    public List<String> letterCasePermutation(String S)
    {
        List<String> rst = new ArrayList();
        if (S == null || S.length() == 0)
        {
            rst.add("");
            return rst;
        }
        dsf(rst, S.toCharArray(), 0, new char[S.length()]);
        return rst;
    }

    private void dsf(List<String> rst, char[] s, int idx, char[] chars)
    {
        if (idx == s.length)
        {
            rst.add(String.valueOf(chars));
            return;
        }
        char c = s[idx];
        if (c >= 'a' && c <= 'z')
        {
            char[] cc = Arrays.copyOf(chars, chars.length);
            cc[idx] = (char)(c - 32);
            dsf(rst, s, idx + 1, cc);
        }
        else if(c >= 'A' && c <= 'Z')
        {
            char[] cc = Arrays.copyOf(chars, chars.length);
            cc[idx] = (char)(c + 32);
            dsf(rst, s, idx + 1, cc);
        }

        chars[idx] = c;
        dsf(rst, s, idx + 1, chars);
    }

}
