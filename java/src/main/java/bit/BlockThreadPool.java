package bit;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 十月 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BlockThreadPool
{
    private ThreadPoolExecutor pool = null;

    public BlockThreadPool(int poolSize)
    {
        System.out.println(Runtime.getRuntime().availableProcessors());
        pool = new ThreadPoolExecutor(3, 3, 0, TimeUnit
        .MINUTES,
            new LinkedBlockingQueue<Runnable>(10),
//            new BlockRejectedExecutionHandler());
            new ThreadPoolExecutor.CallerRunsPolicy());

       /* pool = new ThreadPoolExecutor(poolSize,
            poolSize,
            0,
            TimeUnit.MILLISECONDS,
//            new ArrayBlockingQueue<Runnable>(5),
            new LinkedBlockingQueue<>(5),
            new CustomThreadFactory(),
//            new CustomRejectedExecutionHandler());
            new ThreadPoolExecutor.CallerRunsPolicy());*/
    }

    public void destory()
    {
        if (pool != null)
        {
            pool.shutdownNow();
        }
    }

    private class CustomThreadFactory implements ThreadFactory
    {
        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r)
        {
            Thread t = new Thread(r);
            String threadName = BlockThreadPool.class.getSimpleName() + count.addAndGet(1);
            t.setName(threadName);
            return t;
        }
    }

    private class BlockRejectedExecutionHandler implements RejectedExecutionHandler
    {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
        {
            if (!executor.isShutdown())
            {

                try
                {
                    // 核心改造点，由blockingqueue的offer改成put阻塞方法
                    executor.getQueue().put(r);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void execute(Runnable runnable)
    {
        this.pool.execute(runnable);
    }

    // 测试构造的线程池
    public static void main(String[] args)
        throws InterruptedException
    {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
//        queue.put("a");
//        queue.put("b");
//        queue.put("c");
//        queue.put("d");
//        queue.put("e");
//        queue.put("f");

        BlockThreadPool pool = new BlockThreadPool(3);
        long start = System.currentTimeMillis();
        for (int i = 1; i < 100; i++)
        {
            System.out.println("提交第" + i + "个任务!");
            pool.execute(new MyRun(i));
            System.out.println("【提交第" + i + "个任务成功！】");
        }

        // 2.销毁----此处不能销毁,因为任务没有提交执行完,如果销毁线程池,任务也就无法执行了
        // exec.destory();

        long end = System.currentTimeMillis();
        System.out.println("================================" + (end - start));
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    static class MyRun implements Runnable{
        private int k;

        public MyRun(int k)
        {
            this.k = k;
        }

        @Override
        public void run()
        {
            try
            {
//                System.out.println("["+k + "]start====");
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("["+k + "]start====");
//                System.out.println("[end]===="+k );
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
