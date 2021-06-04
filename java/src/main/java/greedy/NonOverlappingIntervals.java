package greedy;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * @author liming
 * @version [版本号, 6月 04, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class NonOverlappingIntervals
{
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)->{
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }
            else{
                return o1[1] - o2[1];
            }
        });
        int left = 0, right = 0, rst = 0;
        for(int i = 0; i < intervals.length; i++){
            int[] current = intervals[i];
            left = current[0];
            right = current[1];
            while(++i < intervals.length){
                if(intervals[i][1] <= right){
                    left = intervals[i][0];
                    right = intervals[i][1];
                    rst++;
                }
                else if(intervals[i][0] < right){
                    rst++;
                }
                else{
                    i--;
                    break;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args)
    {
        int[][] ints = new int[][]{
            {1,2}, {2,3}, {3,4}, {1,3}
        };
        System.out.println(NonOverlappingIntervals.eraseOverlapIntervals(ints));
        ints =  new int[][]{
            {1,2}, {2,3}
        };
        System.out.println(NonOverlappingIntervals.eraseOverlapIntervals(ints));
    }
}
