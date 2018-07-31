package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author liming
 * @version [版本号, 六月 27, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TwoSum
{
    /**
     * 暴力方式
     * 1.排序
     * 2.循环
     * 二分法查找target-nums[n]的数据
     * 时间复杂度O(n^2)
     *
     * @param nums
     * @param target
     */
    public int[] twoSum(int[] nums, int target)
    {
        int[] rst = new int[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            int expect = target - nums[i];
            int idx = Arrays.binarySearch(nums, expect);
            if (idx >= 0 && idx != i)
            {
                if (idx < i)
                {
                    rst[0] = idx;
                    rst[1] = i;
                }
                else
                {
                    rst[0] = i;
                    rst[1] = idx;
                }
                break;
            }
        }
        return rst;
    }

    /**
     * hash code的方式，空间换时间
     * 空间复杂度O(n)
     * 时间复杂度O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target)
    {
        int[] rst = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            int val = target - nums[i];
            if (map.containsKey(val))
            {
                rst[0] = map.get(val);
                rst[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return rst;
    }



}
