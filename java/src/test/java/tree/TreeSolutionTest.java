package tree;

import org.junit.Before;
import org.junit.Test;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 30, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TreeSolutionTest
{
    @Test
    public void buildTree()
        throws Exception
    {
        TreeNode node = solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node.val);
    }

    private TreeSolution solution;
    @Before
    public void setUp()
        throws Exception
    {
        solution = new TreeSolution();
    }

    @Test
    public void isSymmetric()
        throws Exception
    {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node34 = new TreeNode(3);
        TreeNode node32 = new TreeNode(4);
        TreeNode node33 = new TreeNode(4);
        node1.left = node2;
        node1.right = node22;
        node2.left = node31;
        node2.right = node32;
        node22.left = node33;
        node22.right = node34;
        boolean rst = solution.isSymmetric(node1);
        System.out.println(rst);
    }

    @Test
    public void testSortedArrayToBST(){
        int[] arrays = new int[]{-10,-3,0,5,9};
        TreeNode node = solution.sortedArrayToBST(arrays);
    }
    @Test
    public void inorderTraversal()
        throws Exception
    {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(solution.inorderTraversal(root));
    }
}