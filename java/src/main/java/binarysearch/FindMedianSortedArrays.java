package binarysearch;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * @author liming
 * @version [版本号, 5月 07, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FindMedianSortedArrays
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int len1 = nums1.length, len2 = nums2.length;
        boolean ji = ((len1 + len2) % 2) > 0;
        int mid = ji ? (len1 + len2) / 2 + 1 : (len1 + len2) / 2;
        if (ji)
            return kthElement(nums1, nums2, mid);
        else
        {
            double mid1 = kthElement(nums1, nums2, mid);
            double mid2 = kthElement(nums1, nums2, mid + 1);
            return (mid1+mid2)/2;
        }
    }

    public int kthElement(int[] nums1, int[] nums2, int k)
    {
        int lastIdx1 = nums1.length - 1, lastIdx2 = nums2.length - 1;
        int index1 = 0, index2 = 0;
        while (true)
        {
            if (lastIdx1 < index1)
            {
                return nums2[index2 + k - 1];
            }
            if (lastIdx2 < index2)
            {
                return nums1[index1 + k - 1];
            }
            int half = k / 2 == 0 ? 1 : k / 2;
            int newIdx1 = Math.min(index1 + half - 1, lastIdx1);
            int newIdx2 = Math.min(index2 + half - 1, lastIdx2);
            if (nums1[newIdx1] <= nums2[newIdx2])
            {
                if (k == 1)
                {
                    return nums1[newIdx1];
                }
                k -= (newIdx1 - index1 + 1);
                index1 = newIdx1 + 1;

            }
            else
            {
                if (k == 1)
                {
                    return nums2[newIdx2];
                }
                k -= (newIdx2 - index2 + 1);
                index2 = newIdx2 + 1;
            }

        }
    }

    public static void main(String[] args)
    {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();

        double i = findMedianSortedArrays.findMedianSortedArrays(new int[] {1, 2, 4, 5, 7, 8, 10},
            new int[] {0, 1, 2, 3, 6, 7, 9, 12, 15});
        System.out.println(i);
        i = findMedianSortedArrays.findMedianSortedArrays(new int[] {1},
            new int[] {});
        System.out.println(i);
    }
}
