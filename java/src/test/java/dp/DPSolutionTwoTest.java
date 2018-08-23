package dp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 22, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DPSolutionTwoTest
{
    private DPSolutionTwo dpSolutionTwo;
    @Before
    public void setUp()
        throws Exception
    {
        dpSolutionTwo = new DPSolutionTwo();
    }

    @Test
    public void minimumTotal()
        throws Exception
    {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(1);
        List<Integer> l2 = new ArrayList<>(2);
        List<Integer> l3 = new ArrayList<>(3);
        List<Integer> l4 = new ArrayList<>(4);
        l1.add(2);
        l2.add(3);
        l2.add(4);
        l3.add(6);
        l3.add(5);
        l3.add(7);
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        dpSolutionTwo.minimumTotal(list);
    }

}