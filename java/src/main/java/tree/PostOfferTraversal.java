package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 27, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class PostOfferTraversal
{
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList();
        if(root == null){
            return rst;
        }
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root);
        root = root.left;
        TreeNode prev = null;
        while(!stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == prev){
                rst.add(root.val);
                prev = root;
                root = null;
            }
            else{
                stack.push(root);
                root = root.right;
            }
        }
        return rst;
    }

    public static void main(String[] args)
    {
        Map<TreeNode, Integer> p = new HashMap();
        p.put(null, 1);
        TreeNode root = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        PostOfferTraversal postOfferTraversal = new PostOfferTraversal();
        postOfferTraversal.postorderTraversal(root);

    }
}
