package dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* DPSolution Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 2, 2018</pre> 
* @version 1.0 
*/ 
public class DPSolutionTest { 

    private DPSolution dpSolution ;
@Before
public void before() throws Exception {
    dpSolution = new DPSolution();
} 

@After
public void after() throws Exception {
    dpSolution = null;
} 

/** 
* 
* Method: cut(int num) 
* 
*/ 
@Test
public void testCut() throws Exception {
    Assert.assertEquals(22,dpSolution.cut(8));
} 

@Test
    public void testMinTime()
{
    int[] nums = {1,2,5,10};
    Assert.assertEquals(17, dpSolution.minTime(nums));
    nums = new int[] {1, 2, 5, 10,15};
    Assert.assertEquals(28, dpSolution.minTime(nums));
}

} 
