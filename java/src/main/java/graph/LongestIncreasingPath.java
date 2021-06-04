package graph;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 6月 02, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LongestIncreasingPath
{
    public int longestIncreasingPath(int[][] matrix) {
        int columnLength = matrix[0].length;
        int[][] maxLen = new int[matrix.length][columnLength];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < columnLength; j++){
                if(maxLen[i][j] == 0)
                    dsf(matrix, maxLen, i, j);
            }
        }
        return maxVal;
    }
    int maxVal = 0;
    public int dsf(int[][] matrix, int[][] maxLen, int i, int j){
        int maxAround = 0;
        //up
        if(i - 1 >= 0 && matrix[i][j] <  matrix[i-1][j]){
            maxAround = maxLen[i-1][j] > 0 ? maxLen[i-1][j] : dsf(matrix,
                maxLen, i-1, j);
        }
        //down
        if(i + 1 < matrix.length && matrix[i][j] <  matrix[i+1][j]){
            maxAround = Math.max(maxAround, maxLen[i+1][j] > 0 ? maxLen[i+1][j] :
                dsf(matrix,
                maxLen, i+1, j));
        }
        //left
        if(j - 1 >= 0 && matrix[i][j] <  matrix[i][j -1]){
            maxAround = Math.max(maxAround, maxLen[i][j-1] > 0 ?
                maxLen[i][j-1] :
                dsf(matrix,
                    maxLen, i, j-1));
        }
        //right
        if(j + 1 < matrix[0].length  && matrix[i][j] <  matrix[i][j +1]){
            maxAround = Math.max(maxAround, maxLen[i][j+1] > 0 ?
                maxLen[i][j+1] :
                dsf(matrix,
                    maxLen, i, j+1));
        }
        maxLen[i][j] = maxAround + 1;
        maxVal = Math.max(maxVal, maxLen[i][j]);
        return maxLen[i][j];
    }

    public static void main(String[] args)
    {
        LongestIncreasingPath path = new LongestIncreasingPath();
        path.longestIncreasingPath(
            new int[][]{
                {3,4,5},{3,2,6},{2,2,1}
            });
    }
}
