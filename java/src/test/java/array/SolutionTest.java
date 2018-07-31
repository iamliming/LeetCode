package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import node.ListNode;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 27, 2018</pre>
 */
public class SolutionTest
{
    private Solution solution;

    @Before
    public void before()
        throws Exception
    {
        solution = new Solution();
    }

    @After
    public void after()
        throws Exception
    {
        solution = null;
    }

    /**
     * Method: maxArea(int[] nums)
     */
    @Test
    public void testMaxArea()
        throws Exception
    {
        int[] nums = new int[] {4, 3, 1};
        Assert.assertEquals(solution.maxArea(nums), 3);
        nums = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(solution.maxArea(nums), 49);
    }

    @Test
    public void testThreeSum()
    {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        int[][] except = new int[][] {
            {-1, -1, 2},
            {-1, 0, 1}
        };
        int[][] rst = solution.threeSum(nums, 0);
        Assert.assertArrayEquals(except, rst);
    }

    @Test
    public void testRemoveDuplice()
    {
        int[] nums = new int[] {0, 0, 1, 1, 2, 3, 3, 4, 4, 8, 8};
        Assert.assertEquals(solution.removeDuplicates(nums), 6);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testCanJump()
    {
        int[] nums = {1, 2, 1, 1, 4};
        Assert.assertTrue(solution.canJump(nums));
        nums = new int[] {3, 2, 1, 0, 4};
        Assert.assertTrue(!solution.canJump(nums));
        System.out.println(nums);
    }

    @Test
    public void testLetterCombinations()
    {
        String letters = "23";
        List<String> rst = solution.letterCombinations(letters);
        List<String> except = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assert.assertEquals(except, rst);

    }

    @Test
    public void longestPalindrome()
    {
        String s = "babad";
        String rst = solution.longestPalindrome(s);
        Assert.assertEquals("bab",rst);
    }
    @Test
    public void testMergeKLists()
    {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(5);
        ListNode node10 = new ListNode(8);
        node8.next = node9;
        node9.next = node10;

        ListNode[] nodes = new ListNode[3];
        nodes[0] = node1;
        nodes[1] = node4;
        nodes[2] = node8;
        solution.mergeKLists(nodes);

        nodes = new ListNode[2];
        ListNode node11 = new ListNode(-2);
        ListNode node22 = new ListNode(-1);
        ListNode node33 = new ListNode(-1);
        node11.next = node22;
        node22.next = node33;
        nodes[0] = node11;
        solution.mergeKLists(nodes);
    }
    public void testUniquePaths()
    {
        int rst = solution.uniquePaths(3, 2);
        System.out.println(rst);
        Assert.assertEquals(rst, 3);

        rst = solution.uniquePaths(7, 3);
        System.out.println(rst);
        Assert.assertEquals(rst, 28);
    }

    @Test
    public void testUniquePathⅡ()
    {
        int[][] obstacleGrid = new int[][]
            {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                //                {0, 0, 0, 0}*/
            };
        Assert.assertEquals(solution.uniquePathsWithObstacles(obstacleGrid), 2);
        obstacleGrid = new int[][] {{0, 0}};
        Assert.assertEquals(solution.uniquePathsWithObstacles(obstacleGrid), 1);
        obstacleGrid = new int[][]
            {
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {
                0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {
                1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, {
                0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {
                0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0}, {
                1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {
                0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0}, {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {
                0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {
                1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1}, {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0}, {
                0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {
                0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1}, {
                1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {
                0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1}, {
                0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1}, {
                1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {
                0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {
                0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0}
            };
        Assert.assertEquals(solution.uniquePathsWithObstacles(obstacleGrid), 1637984640);
        //        Assert.assertEquals(solution.uniquePathsWithObstacles(obstacleGrid),1637984640);

    }

    @Test
    public void testMinPathSum()
    {
        int[][] nums = {{1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        Assert.assertEquals(solution.minPathSum(nums), 7);
    }

    @Test
    public void testLargestRectangleArea()
    {
        int[] nums = {2,1,5,6,2,3};
        Assert.assertEquals(solution.largestRectangleArea(nums), 10);
    }

    @Test
    public void testAddTwoNumbers(){
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        solution.addTwoNumbers(node1, node21);

    }

    @Test
    public void testHp(){
        int[][] test = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
        solution.calculateMinimumHP(test);
    }

    @Test
    public void testTrap(){
        Character c = 'a';
        System.out.println(c.hashCode());
        c = 'b';
        System.out.println(c.hashCode());
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        solution.trap(nums);
        nums = new int[]{5,4,1,2};
        solution.trap(nums);
    }

    @Test
    public void test(){
        solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    @Test
    public void testQueue(){

        int num = 5000;
        for(;num < 300000;){
            num *= Math.E*1.5;
        }
        //solution.solveNQueens(3);
    }
    @Test
    public void testinsert()
    {
        //[[1,2],[3,5],[6,7],[8,10],[12,16]]

        //[[0,3],[4,4],[8,8],[18,21]]
//        Solution.Interval interval1 = new Solution.Interval(1,2);
//        Solution.Interval interval2 = new Solution.Interval(3,5);
//        Solution.Interval interval3 = new Solution.Interval(6,7);
//        Solution.Interval interval4 = new Solution.Interval(8,10);

        Solution.Interval interval1 = new Solution.Interval(0,3);
        Solution.Interval interval2 = new Solution.Interval(4,4);
        Solution.Interval interval3 = new Solution.Interval(8,8);
        Solution.Interval interval4 = new Solution.Interval(18,21);

        Solution.Interval interval5 = new Solution.Interval(12,16);
        Solution.Interval interval = new Solution.Interval(4,6);
        List<Solution.Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
//        list.add(interval5);
        List<Solution.Interval> rst = solution.insert(list, interval);
//        for(Solution.Interval i: rst){
//            System.out.println(i.start+","+i.end);
//        }


        solution.letterCasePermutation("a1");

    }

    @Test
    public void testMulip(){
        char c = '2';
        char c1 = '3';
        int val = (c-'0')*(c1-'0');
        System.out.println(val);
        c = 9+'0';
        System.out.println(c);
    }

}
