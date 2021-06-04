package binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 378. 有序矩阵中第 K 小的元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *
 *
 * 提示：
 *
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 *
 * @author liming
 * @version [版本号, 5月 18, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class KthSmallest
{
    public int kthSmallest(int[][] matrix, int k) {
        if(k == 1)
            return matrix[0][0];
        int len = matrix.length;

        return 1;
    }

    public static void main(String[] args)
    {
        List<String> rst = new ArrayList<>();
        String a = "abc";
        rst.add(a);
        a = "bcd";
        rst.add(a);
        System.out.println(rst.get(0)+rst.get(1));
    }
}
