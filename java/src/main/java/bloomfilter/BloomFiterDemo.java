package bloomfilter;

import java.nio.charset.Charset;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 3月 21, 2020]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BloomFiterDemo
{
    public static void main(String[] args)
    {
        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 100000,
            0.0001d);
        System.out.println(filter.approximateElementCount());
        filter.put("abc");
        System.out.println(filter.mightContain("abcd"));
    }
}
