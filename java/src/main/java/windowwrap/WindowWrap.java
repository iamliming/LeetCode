package windowwrap;

import java.util.Random;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 3月 23, 2020]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class WindowWrap
{
    public int maxSum(int[] nums, int k){
        if(nums == null || nums.length < k){
            throw new IllegalArgumentException("nums length is too short");
        }
        int maxSum = 0;
        for(int i =0; i < k; i++){
            maxSum += nums[i];
        }
        int currentSum = maxSum;
        for(int i = k; i<nums.length; i++){
            currentSum = currentSum + nums[i] - nums[i - k];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args)
    {
        WindowWrap windowWrap = new WindowWrap();
        int[] nums =  new int[10];
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            nums[i] = random.nextInt(100);
            System.out.print(nums[i]+",");
        }
        System.out.println();
        System.out.println(windowWrap.maxSum(nums, 3));
    }
}
