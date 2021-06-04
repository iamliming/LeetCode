package binarysearch;

import java.util.Deque;
import java.util.LinkedList;

import tree.TreeNode;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 25, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ValidTree
{
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList();
        Integer innerVal = null;
        System.out.println(innerVal);
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(innerVal != null && root.val <= innerVal){
                return false;
            }
            innerVal = root.val;
            root = root.right;
        }
        return true;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        insert(root, val);
        return root;
    }
    public void insert(TreeNode node, int val){
        if(node.val > val){
            if(node.left == null){
                node.left = new TreeNode(val);
            }
            else{
                insert(node.left, val);
            }
        }
        else if(node.val < val){
            if(node.right == null){
                node.right = new TreeNode(val);
            }
            else{
                insert(node.right, val);
            }
        }
    }
   /* public TreeNode createTree(Integer[] vals){
        if(vals == null || vals.length == 0)
            return null;
        TreeNode root = new TreeNode(vals[0]);
        int currentLevel = 1, nextLevel;
        for(int i = 0; i < vals.length; i++){

        }
    }*/
    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        ValidTree tree = new ValidTree();
        tree.isValidBST(node1);

    }
}
