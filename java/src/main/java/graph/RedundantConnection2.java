package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 685. 冗余连接 II
 * 在本问题中，有根树指满足以下条件的 有向
 * 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
 *
 * 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n
 * 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui
 * 是 vi 的一个父节点。
 *
 * 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：edges = [[1,2],[1,3],[2,3]]
 * 输出：[2,3]
 * 示例 2：
 *
 *
 * 输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * 输出：[4,1]
 * 注意:
 *
 * @author liming
 * @version [版本号, 6月 02, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RedundantConnection2
{
    public int[] findRedundantConnection(int[][] edges) {
        int nodeNum = edges.length;
        int[] indegree = new int[nodeNum + 1];
        List<int[]> conflictEdge = new ArrayList<>();
        for(int i = 0; i < nodeNum; i++){
            indegree[edges[i][1]]++;
        }
        for(int i = nodeNum - 1; i >= 0; i--){
            if(indegree[edges[i][1]] == 2){
                conflictEdge.add(edges[i]);
            }
        }
        if(!conflictEdge.isEmpty()){
            if(isRemovedEdges(nodeNum, edges, conflictEdge.get(0))){
                return conflictEdge.get(0);
            }
            else{
                return conflictEdge.get(1);
            }
        }

        int[] parent = new int[edges.length + 1];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            if(isSameNode(parent, edge)){
                return edge;
            }
        }
        return null;
    }
    public void union(int[] parent, int i, int j){
        parent[i] = j;
    }
    public int find(int[] parent, int idx){
        if(parent[idx] != idx){
            parent[idx] =  find(parent, parent[idx]);
        }
        return parent[idx];
    }
    public boolean isSameNode(int[] parent, int[] edge){
        int p0 = find(parent, edge[0]), p1 = find(parent, edge[1]);
        if(p0 == p1){
            return true;
        }
        union(parent, p0, p1);
        return false;
    }
    public boolean isRemovedEdges(int nodeNum, int[][] edges, int[] conflictEdge){
        int[] parent = new int[nodeNum + 1];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            if(conflictEdge == edge)
                continue;
            if(isSameNode(parent, edge)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[][] edges = new int[][]{
            {1,2},{2,3},{3,4},{4,1},{1,5}
        };
        RedundantConnection2 redundantConnection2 = new RedundantConnection2();
        int[] rst = redundantConnection2.findRedundantConnection(edges);
        System.out.println(rst[0]+":"+rst[1]);
    }
}
