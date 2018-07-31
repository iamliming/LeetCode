package dp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

@Test
    public void testCloneNode()
{
    DPSolution.TreeNode node = new DPSolution.TreeNode(1);
    node.left = new DPSolution.TreeNode(2);
    node.right = new DPSolution.TreeNode(3);
    node.left.left = new DPSolution.TreeNode(4);
    node.left.right = new DPSolution.TreeNode(5);

    DPSolution.TreeNode rst = dpSolution.clone(node);
    System.out.println(rst);
    dpSolution.generateTrees(3);

}
@Test
public void testisInterleave(){
    dpSolution.numDistinct("ab","a");
    dpSolution.isInterleave("aabcc","dbbca","aadbbcbcac");
}
@Test
    public void testisValid(){
    dpSolution.isValid("]");
}
@Test
    public void testCanJump(){
        int[] nums = new int[]{3,2,1,0,4};
        dpSolution.canJump(nums);
}
} 
