package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 * to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * <p>
 * given array nums = [-1,2,1,-4], and target =1;
 * the sum that is closest is -1+2+1 = 2;
 *
 * @author liming
 * @version [版本号, 六月 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ArraySumClosest
{
    //以target为原点，去除离原点最远的 length(nums)-3个点剩下就是结果
    //先对数组进行排序
    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        //需要排除的数量
        int length = nums.length;
        int rst = nums[0] + nums[1] + nums[length - 1];

        for (int i = 0; i < length - 2; i++)
        {
            int start = i + 1, end = length - 1;
            while (start < end)
            {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target)
                {
                    end--;
                }
                else
                {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(rst - target))
                {
                    rst = sum;
                }
            }
        }
        return rst;
    }

    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a
     * + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     *
     * O(n^3)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[][] fourSumclose(int[] nums, int target)
    {
        Arrays.sort(nums);
        List<int[]> rsts = new ArrayList<int[]>();
        int len = nums.length;
        for(int i = 0;i<len - 3;i++)
        {
            for(int j = i+1;j< len -2; j++)
            {
                for(int start = j+1,end = len - 1; start < end; )
                {
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum == target)
                    {
                        int[] item = {nums[i],nums[j],nums[start],nums[end]};
                        if(!rsts.contains(item))
                        {
                            rsts.add(item);
                        }
                    }
                    if(sum < target)
                    {
                        start++;
                    }
                    else{
                        end--;
                    }
                }
            }
        }
        int[][] rst = new int[rsts.size()][4];
        rsts.toArray(rst);
        return    rst;
    }
}
