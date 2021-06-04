package heap;

import tree.TreeNode;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 27, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

public class BalancedTree
{
    class Heights{
        int min = 0;
        int max = 0;
        boolean isBanlanced = false;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) > -1;
    }
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
        {
            return -1;
        }
        else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
