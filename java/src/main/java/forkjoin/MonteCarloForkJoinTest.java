package forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 十二月 17, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MonteCarloForkJoinTest
{
    public static void main(String[] args)
    {
        Long start1 = System.currentTimeMillis();
        Long count = 100000000L;
        MonteCarloForkJoin monteCarloForkJoin = new MonteCarloForkJoin(1L, count);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Long sum = forkJoinPool.invoke(monteCarloForkJoin);
        double pi = 4.0 * sum / count;
        System.out.println(forkJoinPool.getPoolSize());
        System.out.println("PI=" + pi);
        Long end1 = System.currentTimeMillis();
        System.out.println("耗费：" +(end1 - start1));

        int c1 = 100000000;
        int s1 = 0;
        Random random = new Random();
        for(int i = 0; i < c1; i++){
            double x = random.nextDouble();
            double y = random.nextDouble();
            if((x*x + y*y) <= 1){
                s1++;
            }
        }
        double PI = 4.0 * s1/c1;
        System.out.println("p="+PI);
        Long end2 = System.currentTimeMillis();
        System.out.println("耗费：" +(end2 - end1));
    }
}
