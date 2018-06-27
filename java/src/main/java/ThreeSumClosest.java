import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 *  given array nums = [-1,2,1,-4], and target =1;
 *  the sum that is closest is -1+2+1 = 2;
 * @author liming
 * @version [版本号, 六月 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ThreeSumClosest
{
    //以target为原点，去除离原点最远的 length(nums)-3个点剩下就是结果
    //先对数组进行排序
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        //需要排除的数量
        int length = nums.length;
        int rst = nums[0] + nums[1] + nums[length - 1];

        for(int i = 0; i < length - 2; i++)
        {
            int start = i + 1, end = length - 1;
            while(start < end)
            {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target)
                {
                    end--;
                }
                else{
                    start++;
                }
                if(Math.abs(sum-target) < Math.abs(rst-target))
                {
                    rst = sum;
                }
            }
        }
        return rst;
    }
}
