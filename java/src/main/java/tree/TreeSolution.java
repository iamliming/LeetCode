package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 30, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TreeSolution
{
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> oneStack = new LinkedList();
        Deque<TreeNode> secStack = new LinkedList();
        oneStack.push(root);
        while(isNotEmpty(oneStack) || isNotEmpty(secStack)){
            if(isNotEmpty(oneStack)){
                while(isNotEmpty(oneStack)){
                    TreeNode nodeLeft = oneStack.poll();
                    if(!isNotEmpty(oneStack)){
                        if(nodeLeft != null){
                            secStack.push(nodeLeft.right);
                            secStack.push(nodeLeft.left);
                        }
                    }
                    else{
                        TreeNode nodeRight = oneStack.pop();
                        if(nodeLeft == null && nodeRight == null){
                            continue;
                        }
                        else if(nodeLeft != null && nodeRight != null){
                            if(nodeLeft.val != nodeRight.val){
                                return false;
                            }
                            secStack.push(nodeRight.right);
                            secStack.push(nodeRight.left);
                            secStack.push(nodeLeft.right);
                            secStack.push(nodeLeft.left);
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
            else{
                while(isNotEmpty(secStack)){
                    TreeNode nodeLeft = secStack.poll();
                    if(!isNotEmpty(secStack)){
                        if(nodeLeft != null){
                            oneStack.push(nodeLeft.right);
                            oneStack.push(nodeLeft.left);
                        }
                    }
                    else{
                        TreeNode nodeRight = secStack.pop();
                        if(nodeLeft == null && nodeRight == null){
                            continue;
                        }
                        else if(nodeLeft != null && nodeRight != null){
                            if(nodeLeft.val != nodeRight.val){
                                return false;
                            }
                            oneStack.push(nodeRight.right);
                            oneStack.push(nodeRight.left);
                            oneStack.push(nodeLeft.right);
                            oneStack.push(nodeLeft.left);
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    private boolean isNotEmpty(Deque deque){
        return deque != null && deque.size() != 0;
    }
}
