package backtrack;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 25, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BackTrackSolutionTest
{
    BackTrackSolution solution;
    @Before
    public void setUp()
        throws Exception
    {
        solution = new BackTrackSolution();
    }

    @Test
    public void permuteUnique()
        throws Exception
    {
        int[] ints = new int[]{1,1,2};
        List<List<Integer>> rst =  solution.permuteUnique(ints);
        for(List<Integer> list : rst){
            System.out.println(list);
        }
    }

}