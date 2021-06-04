package heap;

/**
 *239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 * @author liming
 * @version [版本号, 5月 12, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MaxSlidingWindow
{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] rst = new int[nums.length - k + 1];
        //初始化
        MaxHeap maxHeap = new MaxHeap(k);
        int i = 0;
        for(; i < k; i++){
            maxHeap.insert(nums[i]);
        }
        rst[0] = maxHeap.top();
        for(; i < nums.length; i++){
            int out = nums[i-k];
            int in = nums[i];
            int top = maxHeap.top();
            if(out == top){
                maxHeap.remove();
                maxHeap.insert(in);
            }
        }
        return rst;
    }
}
