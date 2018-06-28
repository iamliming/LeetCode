package array;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 27, 2018</pre> 
* @version 1.0 
*/ 
public class SolutionTest { 
private Solution solution;
@Before
public void before() throws Exception {
    solution = new Solution();
} 

@After
public void after() throws Exception {
    solution = null;
} 

/** 
* 
* Method: maxArea(int[] nums) 
* 
*/ 
@Test
public void testMaxArea() throws Exception {
    int[] nums = new int[]{4,3,1};
    Assert.assertEquals(solution.maxArea(nums), 3);
    nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    Assert.assertEquals(solution.maxArea(nums), 49);
}

@Test
    public void testThreeSum()
{
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    int[][] except = new int[][]{
        {-1, -1, 2},
        {-1, 0, 1}
    };
    int[][] rst = solution.threeSum(nums, 0);
    Assert.assertArrayEquals(except, rst);
}
@Test
    public void testRemoveDuplice()
{
    int[] nums = new int[]{0,0,1,1,2,3,3,4,4,8,8};
    Assert.assertEquals(solution.removeDuplicates(nums), 6);
    System.out.println(Arrays.toString(nums));
}

} 
