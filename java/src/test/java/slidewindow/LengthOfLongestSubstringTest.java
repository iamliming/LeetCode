package slidewindow;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 06, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LengthOfLongestSubstringTest
{
    LengthOfLongestSubstring lengthOfLongestSubstring;

    @Before
    public void setUp()
        throws Exception
    {
        lengthOfLongestSubstring = new LengthOfLongestSubstring();
    }

    @After
    public void tearDown()
        throws Exception
    {
        lengthOfLongestSubstring = null;
    }

    @Test
    public void lengthOfLongestSubstring()
    {
        String s = "abcabcbb";
        Assert.assertEquals(3 , lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        s = "tmmzuxt";
        Assert.assertEquals(5 , lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
