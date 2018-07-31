package bsf;

import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 24, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SolutionTest
{
    Solution solution;
    @Before
    public void setUp()
        throws Exception
    {

        solution = new Solution();
    }

    @Test
    public void jump()
        throws Exception
    {
        solution.jump(new int[]{2,1,1,0});
    }

}