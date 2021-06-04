package heap;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author liming
 * @version [版本号, 5月 12, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class KthLargest
{
    public int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap(k);
        for(int i : nums){
            minHeap.insert(i);
        }
        return minHeap.top();
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        MaxHeap maxHeap = new MaxHeap(k);
        for(int i : arr){
            maxHeap.insert(i);
        }
        return maxHeap.arr;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{
            0,1,2,1
        };
        KthLargest k = new KthLargest();

        System.out.println(k.findKthLargest(nums, 2));
        k.getLeastNumbers(nums, 1);
    }
}
