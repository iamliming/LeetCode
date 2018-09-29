package unionfind;

/**
 * union find
 *
 * @author liming
 * @version [版本号, 八月 28, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UnionFind
{
    int[] parent;
    int[] height;

    int m, n;

    int count = 0;

    UnionFind(char[][] grid)
    {
        m = grid.length;
        n = grid[0].length;
        parent = new int[m * n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    int id = i * n + j;
                    parent[id] = id;
                    height[id] = 1;
                    count++;
                }
            }
        }
    }

    public void union(int node1, int node2)
    {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2)
        {
            if(height[root1] > height[root2]){
                parent[root2] = root1;
            }
            else if(height[root2] > height[root1]){
                parent[root1] = root2;
            }
            else{
                parent[root2] = root1;
                height[root1]++;
            }
            count--;
        }
    }

    public int find(int node)
    {
        if (parent[node] == node)
        {
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }
}
