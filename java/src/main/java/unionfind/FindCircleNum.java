package unionfind;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 31, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FindCircleNum
{
    public int findCircleNum(int[][] isConnected) {
        int[] pa = new int[isConnected.length];
        for(int i = 0; i < pa.length; i++){
            pa[i] = i;
        }
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(i == j){
                    continue;
                }
                if(isConnected[i][j] == 1){
                    union(find(i ,pa), find(j, pa), pa);
                }
            }
        }
        int rst = 0;
        for(int i = 0; i < pa.length; i++){
            if(pa[i] == i)
                rst++;
        }
        return rst;
    }
    public void union(int i, int j, int[] pa){
        if(i < j){
            pa[j] = i;
        }
        else{
            pa[i] = j;
        }
    }

    public int find(int i, int[] pa){
        /*if(i == pa[i]){
            return i;
        }
        else{
            return find(pa[i], pa);
        }*/
        return i == pa[i] ? i : (pa[i] = find(pa[i], pa));
    }
}
