package string;

import java.util.Arrays;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 23, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Solution
{
    public String multiply(String num1, String num2) {
        char[] mulchar = new char[num1.length()+num2.length()];
        Arrays.fill(mulchar,'0');
        for(int i = num2.length() - 1; i >= 0 ; i--){
            int up = 0;
            for(int j = num1.length() - 1; j >= 0 ; j--){
                int mul = (num2.charAt(i)-'0')*(num1.charAt(j)-'0');
                mul = mul + mulchar[i+j+1]-'0' + up;
                up = mul/10;
                mulchar[i+j+1] = (char)(mul%10 +'0');
            }
            if(up > 0){
                mulchar[i] = (char)(up+'0');
            }
        }
        if(mulchar[0] == '0'){
            return String.valueOf(mulchar, 1, mulchar.length - 1);
        }
        return String.valueOf(mulchar);
    }
}
