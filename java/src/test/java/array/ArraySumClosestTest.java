package array;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import array.ArraySumClosest;

/**
 * ThreeSumClosest Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 27, 2018</pre>
 */
public class ArraySumClosestTest
{

    private ArraySumClosest closest;

    @Before
    public void before()
        throws Exception
    {
        closest = new ArraySumClosest();
    }

    @After
    public void after()
        throws Exception
    {
        closest = null;
    }

    /**
     * Method: threeSumClosest(int[] nums, int target)
     */
    @Test
    public void testThreeSumClosest()
        throws Exception
    {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        Assert.assertEquals(closest.threeSumClosest(nums, target), 2);
        nums = new int[] {-1, -5, 7, 9, 3};
        target = -2;
        Assert.assertEquals(closest.threeSumClosest(nums, target), -3);
    }

    @Test
    public void testFourSumclose()
    {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        int[][] numArray = closest.fourSumclose(nums, target);
        for(int[] rst : numArray)
        {
            System.out.println(Arrays.toString(rst));
        }
        int[][] expect =
            {
                {-2, -1, 1, 2},
                {-2, 0, 0, 2},
                {-1, 0, 0, 1}
            };
        Assert.assertArrayEquals(expect, numArray);
        System.out.println();
        nums = new int[]{-3,-2,-1,0,1,2,3,4};
        int[][] expectA =
            {
                {-3, -2, 1, 4},
                {-3, -2, 2, 3},
                {-3, -1, 0, 4},
                {-3, -1, 1, 3},
                {-3,  0, 1, 2},
                {-2, -1, 0, 3},
                {-2, -1, 1, 2},
            };
        int[][] numsA = closest.fourSumclose(nums, target);
        for(int[] rst : numsA)
        {
            System.out.println(Arrays.toString(rst));
        }
        Assert.assertArrayEquals(expectA, numsA);
    }
} 
