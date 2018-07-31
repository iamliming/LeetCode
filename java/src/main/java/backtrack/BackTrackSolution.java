package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 25, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BackTrackSolution
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        backtrack(nums, rst, new ArrayList<>(nums.length), new boolean[nums.length]);
        return rst;
    }

    private void backtrack(int[] nums, List<List<Integer>> rst, List<Integer> list, boolean[] visit)
    {
        for (int i = 0; i < nums.length; i++)
        {
            if (visit[i])
            {
                continue;
            }
            if(visit[i + 1])
            visit[i] = true;
            list.add(nums[i]);
            if (list.size() == nums.length)
            {
                rst.add(new ArrayList(list));
            }
            else
            {
                backtrack(nums, rst, list, visit);
            }
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
