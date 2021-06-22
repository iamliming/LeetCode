package timewheel;

import java.math.BigDecimal;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 十二月 09, 2019]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Test
{
    public static BigDecimal getRandomMoney(RedPackage _redPackage)
    {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_redPackage.remainSize == 1)
        {
            _redPackage.remainSize--;
            return _redPackage.remainMoney.setScale(2, BigDecimal.ROUND_DOWN);
        }

        BigDecimal random = BigDecimal.valueOf(Math.random());
        BigDecimal min = BigDecimal.valueOf(0.15);

        BigDecimal halfRemainSize =
            BigDecimal.valueOf(_redPackage.remainSize).divide(new BigDecimal(2), BigDecimal.ROUND_UP);
        BigDecimal max1 = _redPackage.remainMoney.divide(halfRemainSize, BigDecimal.ROUND_DOWN);
        BigDecimal minRemainAmount =
            min.multiply(BigDecimal.valueOf(_redPackage.remainSize - 1)).setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal max2 = _redPackage.remainMoney.subtract(minRemainAmount);
        BigDecimal max = (max1.compareTo(max2) < 0) ? max1 : max2;

        BigDecimal money = random.multiply(max).setScale(2, BigDecimal.ROUND_DOWN);
        money = money.compareTo(min) < 0 ? min : money;

        _redPackage.remainSize--;
        _redPackage.remainMoney = _redPackage.remainMoney.subtract(money).setScale(2, BigDecimal.ROUND_DOWN);
        ;
        return money;
    }

    static StringBuilder abc = new StringBuilder();
    public static int getRandomMoney1(RedPackage1 _redPackage)
    {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_redPackage.remainSize == 1)
        {
            _redPackage.remainSize--;
            return _redPackage.remainMoney;
        }

        double random = Math.random();
        abc.append(random+",");
        int min = 15;

        //int halfRemainSize = _redPackage.remainSize/2 + _redPackage.remainSize%2;
        int max1 = _redPackage.remainMoney*20/_redPackage.remainSize;
        int minRemainAmount = min*(_redPackage.remainSize - 1);
        int max2 = _redPackage.remainMoney - minRemainAmount;
        int minMax = ((max1 >= max2) ? max2 : max1);

        int money = (int)(random * minMax);
        money = ((money < min) ? min : money);

        _redPackage.remainSize--;
        _redPackage.remainMoney = _redPackage.remainMoney - money;
        ;
        return money;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 2; i++)
        {
            RedPackage1 moneyPackage = new RedPackage1();
            moneyPackage.remainMoney = 10000;
            moneyPackage.remainSize = 100;

            while (moneyPackage.remainSize != 0)
            {
                System.out.print(getRandomMoney1(moneyPackage) + "   ");
            }

            System.out.println();
            abc = new StringBuilder();

            /*RedPackage moneyPackage = new RedPackage();
            moneyPackage.remainMoney = BigDecimal.valueOf(100);
            moneyPackage.remainSize = 10;

            while (moneyPackage.remainSize != 0)
            {
                System.out.print(getRandomMoney(moneyPackage) + "   ");
            }

            System.out.println();*/
        }


    }

    static class RedPackage
    {
        int remainSize;

        BigDecimal remainMoney;
    }

    static class RedPackage1
    {
        int remainSize;

        int remainMoney;
    }
}
