package unionfind;

import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 28, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UnionFindSolutionTest
{
    @Test
    public void minSwapsCouples()
        throws Exception
    {
        char a = '1';
        char b = '0';
        int i = a - b;
        System.out.println(i);
        int[] ii = new int[]{5,6,4,0,2,1,9,3,8,7,11,10};
        solution.minSwapsCouples(ii);
    }

    UnionFindSolution solution = new UnionFindSolution();
    @Test
    public void numIslands()
        throws Exception
    {
        char[][] island = new char[4][5];
        island[0] = new char[]{'1','1','1','1','0'};
        island[1] = new char[]{'1','1','0','1','0'};
        island[2] = new char[]{'1','1','0','0','0'};
        island[3] = new char[]{'0','0','0','0','0'};
        solution.numIslands(island);
    }

}