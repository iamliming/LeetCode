package tree;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 31, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MaxPathSum
{
    public int maxPathSum(TreeNode root) {
        maxNode(root);
        return rstVal;
    }
    Integer rstVal = Integer.MIN_VALUE;
    public Integer maxNode(TreeNode root){
        if(root == null){
            return null;
        }
        Integer left = maxNode(root.left);
        Integer right = maxNode(root.right);
        Integer rst = root.val, rst1 = root.val;
        if(left != null && left > 0)
        {
            rst += left;
            rst1 += left;
        }
        if(right != null && right > 0)
        {
            rst += right;
            rst1 = Math.max(rst1, root.val + right);
        }
        rstVal = Math.max(rst,rstVal);
        return rst1;
    }

    public static void main(String[] args)
    {
        TreeNode node = TreeUtil.generalTree(new Integer[]{1,2,3});
        MaxPathSum sm = new MaxPathSum();
        System.out.println(sm.maxPathSum(node));

    }
}
