package tree;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 28, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class PruneTree
{
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val ==0){
            return null;
        }
        return root;
    }
}
