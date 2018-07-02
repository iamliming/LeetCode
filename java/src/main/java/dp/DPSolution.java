package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 02, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DPSolution
{
    int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    AtomicInteger times = new AtomicInteger(0);

    /**
     * DP例题：钢条切割
     * 从上到下
     *
     * @param num
     * @return
     */
    public int cut(int num)
    {
        Map<Integer, Integer> bestPrice = new HashMap<>();
        int price = dpCut(num, bestPrice);

        return price;
    }

    //备忘录版本,额外存储空间
    private int dpCut(int len, Map<Integer, Integer> bestPrice)
    {
        if (bestPrice.containsKey(len))
        {
            times.addAndGet(1);
            return bestPrice.get(len);
        }
        int max = prices[len];
        for (int i = 1; i < len && i <= 10; i++)
        {
            times.addAndGet(1);
            max = Math.max(prices[i] + dpCut(len - i, bestPrice), max);
        }
        bestPrice.put(len, max);
        return max;
    }

    //自下而上版本
    private int dpCutBottom(int len)
    {
        return -1;
    }

    /**
     * 【例题1】在一个夜黑风高的晚上，有n（n <= 50）个小朋友在桥的这边，现在他们需要过桥，但是由于桥很窄，每次只允许不大于两人通过，他们只有一个手电筒，所以每次过桥的两个人需要把手电筒带回来，i号小朋友过桥的时间为T
     * [i]，两个人过桥的总时间为二者中时间长者。问所有小朋友过桥的总时间最短是多少。
     *
     * @param a
     * @return
     */
    public int minTime(int[] a)
    {
        Arrays.sort(a);
        int[] rst = new int[a.length];
        rst[0] = a[0];
        rst[1] = a[1];
        int i = opt(a.length, a, rst);
        return i;
    }

    private int opt(int i, int[] a, int[] rst)
    {
        if (rst[i - 1] != 0)
        {
            return rst[i - 1];
        }
        int time = Math.min(opt(i - 1, a, rst) + a[0] + a[i - 1], opt(i - 2, a, rst) + a[0] + a[i - 1] + 2 * a[1]);
        rst[i - 1] = time;
        return time;
    }
}
