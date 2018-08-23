package array;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ArraySolution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 12, 2018</pre>
 */
public class ArraySolutionTest
{

    ArraySolution arraySolution;

    @Before
    public void before()
        throws Exception
    {
        arraySolution = new ArraySolution();
    }

    @After
    public void after()
        throws Exception
    {
        arraySolution = null;
    }

    /**
     * Method: spiralOrder(int[][] matrix)
     */
    @Test
    public void testSpiralOrder()
        throws Exception
    {
        int[][] arr = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        arr = new int[][]{{}};
        arraySolution.spiralOrder(arr);
    }

}
