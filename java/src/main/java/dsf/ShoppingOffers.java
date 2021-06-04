package dsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 10, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ShoppingOffers
{
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> cache = new HashMap<>();
        return dsf(price, special, needs, cache);
    }
    private int dsf(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>,
        Integer> cache){
        if(cache.containsKey(needs))
            return cache.get(needs);
        int rst = 0;
        for(int i = 0; i < needs.size(); i++){
            rst += needs.get(i) * price.get(i);
        }
        for(List<Integer> specialItem : special){
            boolean ok = true;
            List<Integer> clone = new ArrayList<>(needs);
            for(int i = 0; i < clone.size(); i++){
                int diff = clone.get(i) - specialItem.get(i);
                if(diff < 0)
                {
                    ok = false;
                    break;
                }
                clone.set(i, diff);
            }
            if(ok){
                int val = dsf(price, special, clone, cache);
                cache.put(clone, val);
                rst = Math.min(rst, specialItem.get(specialItem.size()) + dsf(price, special, clone, cache));
            }
        }
        return rst;
    }
}
