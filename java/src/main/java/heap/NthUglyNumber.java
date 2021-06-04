package heap;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 14, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class NthUglyNumber
{
    public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        int k1 = 0, k2 = 0, k3 = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int num1 = dp[k1]* 2;
            int num2 = dp[k2]* 3;
            int num3 = dp[k3]* 5;
            dp[i] = Math.min(Math.min(num1, num2), num3);
            if(dp[i] == num1)
                k1++;
            if(dp[i] == num2)
                k2++;
            if(dp[i] == num3)
                k3++;
        }
        return dp[n-1];
    }

    public static void main(String[] args)
    {
        int[] i = {1};
        i[0]++;
        System.out.println(i[0]);
    }
}
