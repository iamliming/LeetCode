import java.util.Arrays;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 六月 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ThreeSumClose
{

    public int threesumclose(int[] sums, int target)
    {
        int times = 0;
        Arrays.sort(sums);
        int result = sums[0] + sums[1] + sums[sums.length - 1];
        for(int i = 0; i < sums.length - 2; i++)
        {
            int start = i+1, end = sums.length -1;
            while(start < end)
            {
                times++;
                int sum = sums[i] + sums[start] + sums[end];
                if(sum > target)
                {
                    end--;
                }
                else{
                    start++;
                }

            }
        }
        return result;
    }
}
