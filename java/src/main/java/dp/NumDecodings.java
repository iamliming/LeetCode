package dp;

import java.util.Stack;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *
 * @author liming
 * @version [版本号, 5月 08, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class NumDecodings
{
    public int numDecodings(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        char[] cArr = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= cArr.length; i++)
        {
            if (cArr[i - 1] != '0')
            {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && cArr[i - 2] != '0' && ((cArr[i - 2] - '0') * 10 + (cArr[i - 1] - '0')) <= 26)
            {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public int maximalRectangle(char[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rowMtx = new int[rows + 1][cols + 1];
        int[][] colMtx = new int[rows + 1][cols + 1];
        int maxArea = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (matrix[i][j] == '0')
                {
                    rowMtx[i + 1][j + 1] = 0;
                    colMtx[i + 1][j + 1] = 0;
                }
                else
                {
                    rowMtx[i + 1][j + 1] = rowMtx[i + 1][j] + 1;
                    colMtx[i + 1][j + 1] = colMtx[i][j + 1] + 1;
                    maxArea = Math.max(maxArea, rowMtx[i + 1][j + 1] * colMtx[i + 1][j + 1]);
                }
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int leftSentinal = -1, rightSentinal = heights.length;
        Stack<Integer> stack = new Stack();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Integer top = null;
        for(int i = 0; i < heights.length; i++){
            while(true)
            {
                if (stack.empty())
                {
                    stack.push(i);
                    left[i] = -1;
                    break;
                }
                top = stack.peek();
                if(heights[top] >= heights[i]){
                    stack.pop();
                }
                else{
                    stack.push(i);
                    left[i] = top;
                    break;
                }
            }
        }
        stack.clear();
        for(int i = heights.length - 1; i >= 0 ; i--){
            while(true)
            {
                if (stack.empty())
                {
                    stack.push(i);
                    right[i] = rightSentinal;
                    break;
                }
                top = stack.peek();
                if(heights[top] >= heights[i]){
                    stack.pop();
                }
                else{
                    stack.push(i);
                    right[i] = top;
                    break;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            max = Math.max(max, (right[i] - left[i] -1) * heights[i]);
        }
        return max;
    }

    public static void main(String[] args)
    {
        NumDecodings numDecodings = new NumDecodings();
        numDecodings.numDecodings("226");

        char[][] matrix = new char[][] {
            {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
        };
        numDecodings.maximalRectangle(matrix);

        System.out.println(numDecodings.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}