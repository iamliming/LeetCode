package bsf;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 24, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Solution
{
    public int jump(int[] nums) {
        int level = 0,nextMax = 0, curMax = 0, i =0;
        if(nums.length < 2){return 1;}
        while(curMax-i+1 > 0){
            level++;
            for(;curMax>=i;i++){
                nextMax=Math.max(nextMax,nums[i]+i);
                if(nextMax>=nums.length-1){return level;}
            }
            curMax = nextMax;
        }
        return 0;
    }
}
