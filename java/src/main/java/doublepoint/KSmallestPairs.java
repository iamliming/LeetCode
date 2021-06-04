package doublepoint;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 31, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class KSmallestPairs
{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> rst = new ArrayList();
        PriorityQueue<Pair> heap =
            new PriorityQueue<>((o1, o2) -> {return o2.num1 + o2.num2 - o1.num1 - o1.num2;});
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(heap.size() < k){
                    heap.add(new Pair(nums1[i], nums2[j]));
                }
                else{
                    Pair pair = heap.peek();
                    if((pair.num1 + pair.num2) > (nums1[i] + nums2[j])) {
                        heap.poll();
                        heap.offer(new Pair(nums1[i], nums2[j]));
                    }
                }
            }
        }
        while (!heap.isEmpty()){
            Pair pair = heap.poll();
            List<Integer> list = new ArrayList<>();
            list.add(pair.num1);
            list.add(pair.num2);
            rst.add(0,list);
        }
        return rst;
    }
    class Pair{
        int num1;
        int num2;

        public Pair(int num1, int num2)
        {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public static void main(String[] args)
    {
        KSmallestPairs pairs = new KSmallestPairs();
        pairs.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 10);

    }
}
