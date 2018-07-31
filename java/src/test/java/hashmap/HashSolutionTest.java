package hashmap;

import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HashSolutionTest
{
    HashSolution solution;
    @Before
    public void setUp()
        throws Exception
    {
        solution = new HashSolution();
    }

    @Test
    public void removeDuplicates()
        throws Exception
    {
        int[] nums = {1,1,1,2,2,3};
        solution.removeDuplicates(nums);
    }

}