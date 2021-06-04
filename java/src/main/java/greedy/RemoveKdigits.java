package greedy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * @author liming
 * @version [版本号, 6月 04, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RemoveKdigits
{
    public static String removeKdigits(String num, int k) {
        if(k >= num.length()){
            return "0";
        }
        int s = num.length() - k;
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while(k > 0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(!stack.isEmpty() && stack.peekLast() == '0'){
            stack.pollLast();
        }
        while(!stack.isEmpty() && k-- > 0){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.length() == 0? "0" : sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(removeKdigits("10001", 2));
    }
}
