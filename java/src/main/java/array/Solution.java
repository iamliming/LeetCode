package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 六月 27, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Solution
{
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x轴共同构成的容器可以容纳最多的水。
     *
     * @param nums
     * @return
     */
    public int maxArea(int[] nums)
    {
        int maxarea = 0, l = 0, r = nums.length - 1;
        while (l < r)
        {
            int area = (r - l) * Math.min(nums[l], nums[r]);
            maxarea = Math.max(maxarea, area);
            if (nums[l] < nums[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return maxarea;
    }

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * <p>
     * 双向指针法，start 在前，end在后
     * 时间复杂度O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[][] threeSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        List<int[]> rstList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++)
        {
            int l = i + 1, r = nums.length - 1;
            while (l < r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target)
                {
                    int[] item = new int[] {nums[i], nums[l], nums[r]};
                    if (!containArray(rstList, item))
                    {
                        rstList.add(item);
                    }
                    l++;
                }
                else if (sum < target)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        int[][] rst = new int[rstList.size()][3];
        return rstList.toArray(rst);
    }

    private boolean containArray(List<int[]> list, int[] array)
    {
        for (int[] k : list)
        {
            if (Arrays.equals(array, k))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 思路：双指针，慢指针在左，快指针在右边，比较两个数大小。
     * 如果不同将慢指针前面的数替换为慢指针指向的数据，并且两个指针同时移动一位。
     * 如果相同，快指正向前移动一位
     * 最後快慢指針指向的位置就是結尾位置
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums)
    {
        int left = 0, right = 1;
        for (; right < nums.length; )
        {
            if (nums[left] < nums[right])
            {
                nums[left + 1] = nums[right];
                left++;
                right++;
            }
            else
            {
                right++;
            }
        }
        return left + 1;

    }

    /**
     * 搜索旋转排序数组
     * <p>
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     * @param nums
     * @return
     */
    public int rotatedArraySearch(int[] nums)
    {
        int idx = -1;
        return idx;
    }

    public boolean canJump(int[] nums)
    {
        for(int i=0;i< nums.length - 1;){
            //0跳跃，并且不是结尾
            if(nums[i] ==0 && i!= nums.length - 1)
            {
                return false;
            }
            i += nums[i];
            if(i == nums.length - 1)
            {
                return true;
            }
        }
        return false;
    }

}
