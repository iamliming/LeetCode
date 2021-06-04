package dp;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author liming
 * @version [版本号, 5月 07, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LongestPalindrome
{
    public String longestPalindrome(String s)
    {
        if (s == null || s.length() == 0)
            return null;
        int len = s.length();
        if (len == 1)
            return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                dp[i][j] = true;
            }
        }
        int maxLen = 1;
        int start = 0;
        for (int j = 1; j < len; j++)
        {
            for (int i = 0; i < j; i++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    if (j - i < 3)
                    {
                        dp[i][j] = true;
                        if (maxLen < j - i + 1)
                        {
                            maxLen = j - i + 1;
                            start = i;
                        }
                    }
                    else if (dp[i + 1][j - 1])
                    {
                        dp[i][j] = true;
                        if (maxLen < j - i + 1)
                        {
                            maxLen = j - i + 1;
                            start = i;
                        }
                    }
                    else
                    {
                        dp[i][j] = false;
                    }
                }
                else
                {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
