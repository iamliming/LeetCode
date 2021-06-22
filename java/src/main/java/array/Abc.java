package array;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 九月 29, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Abc
{
    public static void main(String[] args)
    {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++)
        {
            service.execute(new TaskWait());
        }
        service.shutdown();
    }


}

class TaskWait implements Runnable{
    static AtomicInteger jishu = new AtomicInteger(1);
    @Override
    public void run()
    {
        for(int i = 0; i < 3; i++ )
        {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + ":" + jishu.getAndIncrement());
        }
    }
}
