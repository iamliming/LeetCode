package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HashSolutionTest
{
    @Test
    public void isValidSudoku()
        throws Exception
    {

    }

    @Test
    public void minWindow()
        throws Exception
    {
        String s = solution.minWindow("ABC", "ABC");
        String ss = solution.minWindows("ADOBECODEBANC", "ABC");
        System.out.println(s);
        System.out.println(ss);
    }

    HashSolution solution;

    @Before
    public void setUp()
        throws Exception
    {
        solution = new HashSolution();
    }

    @Test
    public void removeDuplicates()
        throws Exception
    {
        int[] nums = {1, 1, 1, 2, 2, 3};
        solution.removeDuplicates(nums);
    }

    @Test
    public void testfindSubstring()
    {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> rst = solution.findSubstring(s, words);
        List<Integer> expect = Arrays.asList(new Integer[] {0, 9});
        Assert.assertEquals(rst, expect);

        s = "barfoofoobarthefoobarman";
        words = new String[]{"bar","foo","the"};
        expect = Arrays.asList(new Integer[] {6, 9, 12});
        rst = solution.findSubstring(s, words);
        Assert.assertEquals(rst, expect);

        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word", "good", "best", "good"};
        rst = solution.findSubstring(s, words);
        Assert.assertEquals(rst, new ArrayList<Integer>());

        s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        words = new String[]{"fooo","barr","wing","ding","wing"};
        rst = solution.findSubstring(s, words);
        Assert.assertEquals(rst, new Integer[]{13});


    }

}