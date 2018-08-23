package design;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 21, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LRUCacheTest
{
    private LRUCache cache;
    @Before
    public void setUp()
        throws Exception
    {
        cache = new LRUCache(2);
    }


    @Test
    public void put()
        throws Exception
    {
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        Assert.assertEquals(-1, cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        Assert.assertEquals(-1, cache.get(1));       // returns -1 (not found)
        Assert.assertEquals(3, cache.get(3));       // returns 3
        Assert.assertEquals(4, cache.get(4));       // returns 4
    }

}