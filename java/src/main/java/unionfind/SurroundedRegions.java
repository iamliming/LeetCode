package unionfind;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * @author liming
 * @version [版本号, 5月 31, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SurroundedRegions
{
    public void solve(char[][] board) {
        int column = board[0].length;
        Node[][] paNode = new Node[board.length][column];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < column; j++){
                if(i == 0 || i == board.length - 1 || j == 0 || j == column - 1)
                {
                    paNode[i][j] = new Node(i, j, true);
                }
                else{
                    paNode[i][j] = new Node(i, j, false);
                }
            }
        }
        for(int i = 1; i < board.length; i++)
        {
            for (int j = 1; j < column; j++)
            {
                if(board[i][j] == 'O'){
                    if(board[i][j -1] == 'O'){
                        union(i, j - 1, i, j, paNode);
                    }
                    if(board[i - 1][j] == 'O'){
                        union(i - 1, j, i, j, paNode);
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < column; j++){
                if(board[i][j] == 'O' && !find(i, j, paNode).isBorad)
                {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public Node find(int i, int j, Node[][] paNode){
        Node node = paNode[i][j];
        if(node.i == i && node.j == j){
            return node;
        }
        else{
            paNode[i][j] = find(node.i, node.j, paNode);
            return paNode[i][j];
        }
    }
    public void union(int i1, int j1, int i2, int j2, Node[][] paNode){
        Node node1 = find(i1, j1, paNode);
        Node node2 = find(i2, j2, paNode);
        if(node1.isBorad){
            paNode[node2.i][node2.j] = node1;
        }
        else if(node2.isBorad){
            paNode[node1.i][node1.j] = node2;
        }
        else{
            paNode[node2.i][node2.j] = node1;
        }
    }

    class Node{
        int i;
        int j;
        boolean isBorad;

        public Node(int i, int j, boolean isBorad)
        {
            this.i = i;
            this.j = j;
            this.isBorad = isBorad;
        }
    }
}
