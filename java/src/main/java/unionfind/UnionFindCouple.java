package unionfind;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 28, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UnionFindCouple
{
    private int[] parent;
    private int count;

    public int getCount()
    {
        return count;
    }

    public UnionFindCouple(int coupleNum)
    {
        parent = new int[coupleNum];
        for(int i = 0; i < coupleNum; i++){
            parent[i] = i;
        }
        count = coupleNum;
    }

    public int find(int n){
        if(parent[n] == n){
            return n;
        }
        else{
            return find(parent[n]);
        }
    }

    public void union(int m, int n){
        int pm = find(m);
        int pn = find(n);
        if(pm == pn){return;}
        parent[n] = pm;
        count--;
    }
}
