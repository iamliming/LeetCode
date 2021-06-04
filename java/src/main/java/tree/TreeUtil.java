package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 28, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TreeUtil
{
    public static TreeNode generalTree(Integer[] arr){
        TreeNode root = new TreeNode(arr[0]);
        boolean isFirst = true;
        Deque<TreeNode> stack = new LinkedList<>();
        int firstIndex = 1, secondIndex = 0;
        stack.offer(root);
        for(int i = 1; i < arr.length;){
            if(isFirst){
                TreeNode node = stack.poll();
                if(arr[i] != null){
                    node.left = new TreeNode(arr[i]);
                    stack.offer(node.left);
                    secondIndex++;
                }
                i++;
                if(arr[i] != null){
                    node.right = new TreeNode(arr[i]);
                    stack.offer(node.right);
                    secondIndex++;
                }
                i++;
                firstIndex--;
                if(firstIndex == 0){
                    isFirst = false;
                }
            }
            else{
                TreeNode node = stack.poll();
                if(arr[i] != null){
                    node.left = new TreeNode(arr[i]);
                    stack.offer(node.left);
                    firstIndex++;
                }
                i++;
                if(arr[i] != null){
                    node.right = new TreeNode(arr[i]);
                    stack.offer(node.right);
                    firstIndex++;
                }
                i++;
                secondIndex--;
                if(secondIndex == 0){
                    isFirst = true;
                }
            }
        }
        return root;
    }

    public static void main(String[] args)
    {
        generalTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        generalTree(new Integer[]{1,null,2,null,3,null,4,null,null});
    }
}
