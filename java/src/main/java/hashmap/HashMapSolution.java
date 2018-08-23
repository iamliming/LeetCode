package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 14, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HashMapSolution
{
    public boolean isHappy(int n) {
        if(n<1) return false;
        Set<Integer> set = new HashSet();
        int num = n;
        int sum = 0;
        while(num > 0){
            int i = num/10;
            int j = num%10;
            sum += (j*j);
            if(i == 0){
                if(sum == 1) return true;
                if(set.contains(sum)){return false;}
                num = sum;
                set.add(sum);
                sum = 0;
            }
            else{
                num = i;
            }
        }
        return false;
    }

    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        char[] arrS = new char[256];
        char[] arrT = new char[256];
        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(arrS[cs] == 0 && arrT[ct] ==0){
                arrS[cs] = ct;
                arrT[ct] = cs;
            }
            else{
                if(arrS[cs] != ct || arrT[ct] != cs){
                    return false;
                }
            }
        }
        return true;
    }
}
