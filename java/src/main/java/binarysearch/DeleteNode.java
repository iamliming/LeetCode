package binarysearch;

import tree.TreeNode;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 26, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DeleteNode
{
    public TreeNode deleteNode(TreeNode root, int key)
    {
        if(root == null)
            return null;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null && root.right == null){
                root = null;
            }
            else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }


    public int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    public int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }

}
