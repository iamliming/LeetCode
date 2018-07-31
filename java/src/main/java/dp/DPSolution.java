package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 02, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DPSolution
{
    int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    AtomicInteger times = new AtomicInteger(0);

    /**
     * DP例题：钢条切割
     * 从上到下
     *
     * @param num
     * @return
     */
    public int cut(int num)
    {
        Map<Integer, Integer> bestPrice = new HashMap<>();
        int price = dpCut(num, bestPrice);

        return price;
    }

    //备忘录版本,额外存储空间
    private int dpCut(int len, Map<Integer, Integer> bestPrice)
    {
        if (bestPrice.containsKey(len))
        {
            times.addAndGet(1);
            return bestPrice.get(len);
        }
        int max = prices[len];
        for (int i = 1; i < len && i <= 10; i++)
        {
            times.addAndGet(1);
            max = Math.max(prices[i] + dpCut(len - i, bestPrice), max);
        }
        bestPrice.put(len, max);
        return max;
    }

    //自下而上版本
    private int dpCutBottom(int len)
    {
        return -1;
    }

    /**
     * 【例题1】在一个夜黑风高的晚上，有n（n <= 50）个小朋友在桥的这边，现在他们需要过桥，但是由于桥很窄，每次只允许不大于两人通过，他们只有一个手电筒，所以每次过桥的两个人需要把手电筒带回来，i号小朋友过桥的时间为T
     * [i]，两个人过桥的总时间为二者中时间长者。问所有小朋友过桥的总时间最短是多少。
     *
     * @param a
     * @return
     */
    public int minTime(int[] a)
    {
        Arrays.sort(a);
        int[] rst = new int[a.length];
        rst[0] = a[0];
        rst[1] = a[1];
        int i = opt(a.length, a, rst);
        return i;
    }

    private int opt(int i, int[] a, int[] rst)
    {
        if (rst[i - 1] != 0)
        {
            return rst[i - 1];
        }
        int time = Math.min(opt(i - 1, a, rst) + a[0] + a[i - 1], opt(i - 2, a, rst) + a[0] + a[i - 1] + 2 * a[1]);
        rst[i - 1] = time;
        return time;
    }

    static class TreeNode implements Cloneable
    {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n)
    {
        List<TreeNode>[] dp = new List[n + 1];
        List<TreeNode> nodes1 = new ArrayList();
        nodes1.add(new TreeNode(1));
        dp[1] = nodes1;
        for (int i = 2; i <= n; i++)
        {
            //子树左边。最大节点在根节点
            List<TreeNode> nodes = new ArrayList();
            for (TreeNode child : dp[i - 1])
            {
                TreeNode childTree = clone(child);
                TreeNode root = new TreeNode(i);
                root.left = childTree;
                nodes.add(root);
            }
            //最大节点非根
            for (TreeNode rootTree : dp[i - 1])
            {
                TreeNode rightTree = rootTree;
                while (rightTree.right != null)
                {
                    //复制
                    TreeNode cloneTree = clone(rootTree);
                    nodes.add(cloneTree);
                    while (cloneTree.val != rightTree.val)
                    {
                        cloneTree = cloneTree.right;
                    }
                    TreeNode tn = new TreeNode(i);
                    tn.left = cloneTree.right;
                    cloneTree.right = tn;
                    rightTree = rightTree.right;
                }
                TreeNode rootBiggest = clone(rootTree);
                nodes.add(rootBiggest);
                while (rootBiggest.right != null)
                {
                    rootBiggest = rootBiggest.right;
                }
                TreeNode biggest = new TreeNode(i);
                rootBiggest.right = biggest;

            }
            dp[i] = nodes;
        }
        return dp[n];
    }

    public TreeNode clone(TreeNode node)
    {
        TreeNode rst = new TreeNode(node.val);
        if (node.left != null)
        {
            rst.left = clone(node.left);
        }
        if (node.right != null)
        {
            rst.right = clone(node.right);
        }
        return rst;
    }

    public boolean isInterleave(String s1, String s2, String s3)
    {
        //字段为空得情况
        int end1 = s1.length() - 1;
        int end2 = s2.length() - 1;
        int end = s3.length() - 1;
        while (end >= 0)
        {
            if (end1 >= 0 && s3.charAt(end) == s1.charAt(end1))
            {
                end1--;
                end--;
                continue;
            }
            if (end2 >= 0 && s3.charAt(end) == s2.charAt(end2))
            {
                end2--;
                end--;
                continue;
            }

        }
        return end == -1 && end1 == -1 && end2 == -1;
    }

    public int numDistinct(String S, String T)
    {
        // array creation
        int[][] mem = new int[T.length() + 1][S.length() + 1];

        // filling the first row: with 1s
        for (int j = 0; j <= S.length(); j++)
        {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for (int i = 0; i < T.length(); i++)
        {
            for (int j = 0; j < S.length(); j++)
            {
                if (T.charAt(i) == S.charAt(j))
                {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                }
                else
                {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }

    public boolean isValid(String s)
    {
        Deque<Character> stack = new LinkedList<>();
        char c1 = '(';
        char c2 = ')';
        char c3 = '[';
        char c4 = ']';
        char c5 = '{';
        char c6 = '}';
        if (s == null || s.length() == 0)
        {
            return false;
        }
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == c1 || c == c3 || c == c5)
            {
                stack.offer(c);
                continue;
            }
            Character lastC = stack.peekLast();
            if (lastC == null)
            {
                return false;
            }
            if (c == c2 && stack.peekLast() == c1)
            {
                stack.pollLast();
                continue;
            }
            if (c == c4 && stack.peekLast() == c3)
            {
                stack.pollLast();
                continue;
            }
            if (c == c6 && stack.peekLast() == c5)
            {
                stack.pollLast();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis(int n)
    {
        if (n <= 0)
        {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        generate(set, 0, 0, n, "");
        return new ArrayList<>(set);
    }

    private void generate(Set<String> rst, int l, int r, int nums, String sb)
    {
        if (l == nums && r == nums)
        {
            rst.add(sb);
            return;
        }
        if (l < nums)
        {
            generate(rst, l + 1, r, nums, "(" + sb);
        }
        if (r < nums)
        {
            generate(rst, l, r + 1, nums, sb + ")");
        }
    }

    public int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[][] dpItem = new int[nums.length][2];
        int l = 0, r = 0, max = 0;
        dp[0] = nums[0];
        max = dp[0];
        dpItem[0][0] = 0;
        dpItem[0][1] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (dp[i - 1] > 0)
            {
                dp[i] = dp[i - 1] + nums[i];
                dpItem[i][0] = dpItem[i - 1][0];
                dpItem[i][1] = i;
            }
            else
            {
                dp[i] = nums[i];
                dpItem[i][0] = i;
                dpItem[i][1] = i;
            }
            max = Math.max(dp[i], max);
        }
        for (int i = 0; i < dp.length; i++)
        {
            System.out.println(dp[i] + ";" + dpItem[i][0] + "," + dpItem[i][1]);
        }
        return max;
    }

    /**
     * 51. N-Queens
     * DescriptionHintsSubmissionsDiscussSolution
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack
     * each other.
     * <p>
     * <p>
     * <p>
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * <p>
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both
     * indicate a queen and an empty space respectively.
     * <p>
     * Example:
     * <p>
     * Input: 4
     * Output: [
     * [".Q..",  // Solution 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // Solution 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
     */
//    public List<List<String>> solveNQueens(int n) {
//    {
//        if(n < 1){
//            return new ArrayList<>();
//        }
//        List<>
//        List<String[]> row = new ArrayList<>(n);
//        for(int i = 0; i < n; i++){
//            rst
//        }
//    }
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){return false;}
        if(nums.length == 1){return true;}
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i< nums.length; i++){
            if(dp[i-1] == 0){return false;}
            dp[i] = Math.max(dp[i-1] - 1, nums[i]);
        }
        return true;
    }
}
