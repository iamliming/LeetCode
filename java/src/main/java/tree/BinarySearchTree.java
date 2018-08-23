package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 16, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BinarySearchTree
{
    public int[] findMode(TreeNode root) {
        int max = 0;
        Map<Integer,Integer> map = new HashMap();
        if(root == null)
            return new int[0];
        List<Integer> rstList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                rstList.add(entry.getKey());
            }
        }
        int[] rst = new int[rstList.size()];
        for(int i = 0 ; i <  rstList.size(); i++){
            rst[i] = rstList.get(i);
        }
        return rst;
    }
}
