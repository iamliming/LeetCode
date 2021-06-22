package forkjoin;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 十二月 17, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MonteCarloForkJoin extends RecursiveTask<Long>
{
    private Long start;
    private Long end;
    public static final Long critical = 10000000L;//临界值
    public static final Random random = new Random();
    public MonteCarloForkJoin(Long start, Long end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute()
    {
        if(end - start <= critical){
            Long sum = 0L;
            for(;start <= end; start++)
            {
                double x = random.nextDouble();
                double y = random.nextDouble();
                if ((x * x + y * y) <= 1)
                {
                    sum++;
                }
            }
            return sum;
        }
        else{
            Long mid = (start + end)/2;
            MonteCarloForkJoin left  = new MonteCarloForkJoin(start, mid);
            left.fork();
            MonteCarloForkJoin right  = new MonteCarloForkJoin(mid + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }

}
