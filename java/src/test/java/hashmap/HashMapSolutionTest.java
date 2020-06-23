package hashmap;

import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 14, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HashMapSolutionTest
{


    HashMapSolution solution;
    @Before
    public void setUp()
        throws Exception
    {
        solution = new HashMapSolution();
    }

    @Test
    public void isHappy()
        throws Exception
    {
        System.out.println(1 << 2);
        System.out.println(1 << 1);
        solution.isHappy(2);
    }

    @Test
    public void isIsomorphic(){
        solution.isIsomorphic("ab","aa");
    }

    @Test
    public void wordPattern()
        throws Exception
    {
        solution.wordPattern("abba", "dog dog dog dog");
    }
}