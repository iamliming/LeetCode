import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* ThreeSumClosest Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 27, 2018</pre> 
* @version 1.0 
*/ 
public class ThreeSumClosestTest { 

    private ThreeSumClosest closest ;
@Before
public void before() throws Exception {
    closest = new ThreeSumClosest();
} 

@After
public void after() throws Exception {
    closest = null;
} 

/** 
* 
* Method: threeSumClosest(int[] nums, int target) 
* 
*/ 
@Test
public void testThreeSumClosest() throws Exception {
    int[] nums = {-1, 2, 1, -4};
    int target = 1;
    Assert.assertEquals(closest.threeSumClosest(nums,target),2);
    nums = new int[] {-1, -5, 7, 9, 3};
    target = -2;
    Assert.assertEquals(closest.threeSumClosest(nums,target), -3);
}

} 
