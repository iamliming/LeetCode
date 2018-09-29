package unionfind;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 28, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UnionFindSolution
{
    int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid)
    {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == '1')
                {
                    for (int[] d : distance)
                    {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1')
                        {
                            int id1 = i * cols + j;
                            int id2 = x * cols + y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    /**
     * 765. Couples Holding Hands
     *
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row)
    {
        if(row == null || row.length == 0 || row.length % 2 == 1){
            return -1;
        }
        UnionFindCouple uf = new UnionFindCouple(row.length/2);
        for(int i = 0; i < row.length/2; i++){
            int a = row[2*i];
            int b = row[2*i + 1];
            uf.union(a/2, b/2);
        }

        return row.length/2 - uf.getCount();
    }
}
