package string;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 23, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SolutionTest
{
    private Solution solution;
    @Before
    public void setUp()
        throws Exception
    {
        solution = new Solution();
    }

    @After
    public void tearDown()
        throws Exception
    {

    }

    @Test
    public void multiply()
        throws Exception
    {
        Assert.assertEquals(solution.multiply("11","22"),"242");
        solution.multiply("123","456");
    }

}