package montecarlo;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 十二月 17, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MonteCarlo
{
    public static void main(String[] args)
    {
        Random random = new Random();

        OptionalInt sum =
        IntStream.range(1,10000)
            .map(
                s->{
                    double x = random.nextDouble();
                    double y = random.nextDouble();
                    if((x*x + y*y) <= 1){
                        return 1;
                    }
                    return 0;
                }
            ).reduce((a, b) -> a + b)
        ;
        System.out.println(sum.getAsInt());

        double PI = 4.0 * sum.getAsInt()/10000;
        System.out.println("p="+PI);

       /* int count = 500000000;
        int sum = 0;
        for(int i = 0; i < count; i++){
            double x = random.nextDouble();
            double y = random.nextDouble();
            if((x*x + y*y) <= 1){
                sum++;
            }
        }
        double PI = 4.0 * sum/count;
        System.out.println("p="+PI);*/
    }
}
