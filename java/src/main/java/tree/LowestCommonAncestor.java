package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
 *
 * @author liming
 * @version [版本号, 5月 27, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LowestCommonAncestor
{
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new LinkedList<>();
        int contain = 0;
        TreeNode prev = null;
        TreeNode firstRoot = null, secRoot = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == prev){
                if(root.val == p.val || root.val == q.val){
                    contain++;
                    if(contain == 1){
                        firstRoot = root;
                    }
                    else{
                        secRoot = root;
                    }

                }else if(contain == 1){

                }
                prev = root;
                root = null;
            }
            else{
                stack.push(root);
                root = root.right;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        common(root, p, q);
        return rstNode;
    }
    TreeNode rstNode = null;
    public int common(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return 0;
        }
        int rst = common(root.left, p, q);
        if(rst == 2){
            return 2;
        }
        int right= common(root.right, p, q);
        if(right == 2){
            return 2;
        }
        rst += right;
        if(rst == 2){
            rstNode = root;
            return 2;
        }
        if(root.val == p.val || root.val == q.val){
            rst++;
            if(rst == 2){
                rstNode = root;
            }
        }
        return rst;
    }

    public static void main(String[] args)
    {
        TreeNode root = TreeUtil.generalTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        ancestor.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));

    }


}
