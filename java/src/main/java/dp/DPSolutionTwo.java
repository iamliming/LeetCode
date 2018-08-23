package dp;

import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 22, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DPSolutionTwo
{
    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * <p>
     * 例如，给定三角形：
     * <p>
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * <p>
     * 说明：
     * <p>
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle)
    {
        if (triangle == null || triangle.size() == 0)
        {
            return -1;
        }
        Integer[] dp = new Integer[triangle.size()];
        for (int i = 0; i < triangle.size(); i++)
        {
            List<Integer> rowTriangle = triangle.get(i);
            if (i == 0)
            {
                dp[0] = rowTriangle.get(0);
                continue;
            }
            if (i == 1)
            {
                dp[1] = dp[0] + rowTriangle.get(1);
                dp[0] = dp[0] + rowTriangle.get(0);
                continue;
            }
            int prev = 0;
            for (int j = 0; j < rowTriangle.size(); j++)
            {
                if (j == 0)
                {
                    prev = dp[0];
                    dp[0] = dp[0] + rowTriangle.get(0);
                }
                else if (j == rowTriangle.size() - 1)
                {
                    dp[j] = prev + rowTriangle.get(j);
                }
                else
                {
                    int minVal = Math.min(prev, dp[j]);
                    prev = dp[j];
                    dp[j] = minVal + rowTriangle.get(j);
                }
            }
        }
        int rst = Integer.MAX_VALUE;
        for (int val : dp)
        {
            rst = Math.min(rst, val);
        }
        return rst;
    }

    /**
     * 152. 乘积最大子序列
     * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums)
    {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i =0; i < nums.length; i++){
            if(i == 0 || dpMax[i - 1] == 0){
                dpMax[i] = nums[i];
                dpMin[i] = nums[i];
                max = Math.max(dpMax[i], max);
            }
            else{
                int m = nums[i]*dpMax[i - 1];
                int n = nums[i]*dpMin[i - 1];
                dpMax[i] = Math.max(Math.max(m, n), nums[i]);
                dpMin[i] = Math.min(Math.min(m, n), nums[i]);
                max = Math.max(dpMax[i], max);
            }
        }
        return max;
    }
}
