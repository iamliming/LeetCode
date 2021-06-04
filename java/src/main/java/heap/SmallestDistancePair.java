package heap;

/**
 * 719. 找出第 k 小的距离对
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 *
 * @author liming
 * @version [版本号, 5月 13, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SmallestDistancePair
{
    public int smallestDistancePair(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return 0;
        MaxHeap maxHeap = new MaxHeap(k);
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++)
            {
                int rst = Math.abs(nums[j] - nums[i]);
                if(maxHeap.size() < k){
                    maxHeap.insert(rst);
                }
                else{
                    if(maxHeap.top() > rst){
                        maxHeap.remove();
                        maxHeap.insert(rst);
                    }
                }
            }
        }
        return maxHeap.top();
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1,3,2};
        SmallestDistancePair pair = new SmallestDistancePair();
        System.out.println(pair.smallestDistancePair(nums, 3));
    }
}
