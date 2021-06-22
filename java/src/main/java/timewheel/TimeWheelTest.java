package timewheel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.netty.util.HashedWheelTimer;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 十二月 09, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TimeWheelTest
{
    @Test
    public void test1()
        throws InterruptedException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
        System.out.println("start:" + LocalDateTime.now().format(formatter));

        hashedWheelTimer.newTimeout( timeout -> {
            System.out.println("task:" + LocalDateTime.now().format(formatter));}
        , 3, TimeUnit.SECONDS);

        Thread.sleep(5000);
    }
}
