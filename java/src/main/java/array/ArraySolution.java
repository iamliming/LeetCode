package array;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 12, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ArraySolution
{
    public static final int RIGHT = 1;

    public static final int DOWN = 2;

    public static final int LEFT = 3;

    public static final int UP = 4;

    /**
     * 54. Spiral Matrix
     * DescriptionHintsSubmissionsDiscussSolution
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * <p>
     * Input:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix)
    {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1,
            maxNum = matrix.length * matrix[0].length,
            idx = 0, m = 0, n = 0,
            move = RIGHT;
        List<Integer> rst = new ArrayList<>(maxNum);
        while (idx < maxNum)
        {
            if (move == RIGHT)
            {
                while (n <= right)
                {
                    rst.add(matrix[m][n]);
                    idx++;
                    if (n == right)
                    {
                        move = DOWN;
                        top++;
                        m++;
                        break;
                    }
                    else{
                        n++;
                    }
                }
            }
            else if (move == DOWN)
            {
                while (m <= bottom)
                {
                    rst.add(matrix[m][n]);
                    idx++;
                    if (m == bottom)
                    {
                        move = LEFT;
                        right--;
                        n--;
                        break;
                    }
                    else {
                        m++;
                    }
                }
            }
            else if (move == LEFT)
            {
                while (n >= left)
                {
                    rst.add(matrix[m][n]);
                    idx++;
                    if (n == left)
                    {
                        move = UP;
                        bottom--;
                        m--;
                        break;
                    }else{
                        n--;
                    }
                }
            }
            else
            {
                while (m >= top)
                {
                    rst.add(matrix[m][n]);
                    idx++;
                    if (m == top)
                    {
                        move = RIGHT;
                        left++;
                        n++;
                        break;
                    }
                    else{
                        m--;
                    }
                }
            }
        }
        return rst;
    }
}
