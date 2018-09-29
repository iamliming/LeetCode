package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 九月 06, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TreeMapDemo
{
    public static void main(String[] args)
    {


        TreeMap<String, Integer> tree = new TreeMap();
        tree.put("v", 1);
        tree.put("m", 2);
        tree.put("c", 3);
        tree.put("k",4);
        tree.put("v",5);
        tree.put("a",6);
        tree.put("d",7);

        Map.Entry<String, Integer> entry = tree.firstEntry();
        System.out.println(entry);
        entry = tree.lastEntry();
        System.out.println(entry);
        entry = tree.ceilingEntry("d");
        System.out.println(entry);
        entry = tree.higherEntry("d");
        System.out.println(entry);
        entry = tree.floorEntry("c");
        System.out.println(entry);
        entry = tree.lowerEntry("c");
        System.out.println(entry);
        System.out.println(tree.headMap("d").size());
        TreeSet set = new TreeSet();
        Integer[] rst = new Integer[4];
        List<Integer> list = Arrays.asList(rst);
        int[] i =  {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,
        21,84,66,65,36,100,41};

        int n = 0;
        for(int k : i){
            if(k < 26)
                n++;
        }
        Arrays.sort(i);
        System.out.println(n);
        System.out.println(Arrays.toString(i));
    }

    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        TreeSet<Integer> tree = new TreeSet(new Comparator<Node>()
        {
            @Override
            public int compare(Node o1, Node o2)
            {
                return o1.getVal() - o2.getVal();
            }
        });
        Integer[] rst = new Integer[nums.length];
        for(int i = nums.length - 1; i>=0; i--){
            rst[i] = tree.headSet(nums[i]).size();
            tree.add(nums[i]);
        }
        return Arrays.asList(rst);
    }
    class Node {
        private int val;
        private int num;



        public int getVal()
        {
            return val;
        }

        public void setVal(int val)
        {
            this.val = val;
        }

        public int getNum()
        {
            return num;
        }

        public void setNum(int num)
        {
            this.num = num;
        }
    }


}
