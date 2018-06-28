package array;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
* TwoSum Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 27, 2018</pre> 
* @version 1.0 
*/ 
public class TwoSumTest { 

    TwoSum sum ;
@Before
public void before() throws Exception {
    sum = new TwoSum();
} 

@After
public void after() throws Exception {
    sum = null;
} 

/** 
* 
* Method: twoSum(int[] nums, int target) 
* 
*/ 
@Test
public void testTwoSum() throws Exception {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] idx = sum.twoSum(nums, target);
    Assert.assertArrayEquals(new int[] {0, 1},idx);
}

/** 
* 
* Method: twoSumHash(int[] nums, int target) 
* 
*/ 
@Test
public void testTwoSumHash() throws Exception {
    int[] nums = {2, 7, 11, 15};
    int target = 22;
    int[] idx = sum.twoSumHash(nums, target);
    Assert.assertArrayEquals(new int[] {1, 3},idx);
}


} 
