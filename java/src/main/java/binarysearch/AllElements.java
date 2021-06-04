package binarysearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tree.TreeNode;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。
 *
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 * @author liming
 * @version [版本号, 5月 28, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AllElements
{

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> rst = new ArrayList<>();
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        List<Integer> tree1 = tree(root1, stack1);
        List<Integer> tree2 = tree(root2, stack1);
        for(int i = 0, j = 0; i + j < tree1.size() + tree2.size();){
            if(i == tree1.size()){
                rst.add(tree2.get(j++));
            }
            else if(j == tree2.size()){
                rst.add(tree1.get(i++));
            }
            else{
                if(tree1.get(i) <= tree2.get(j)){
                    rst.add(tree1.get(i++));
                }
                else{
                    rst.add(tree2.get(j++));
                }
            }

        }
        return rst;
    }
    public List<Integer> tree(TreeNode node, Deque<TreeNode> stack){
        List<Integer> rst = new ArrayList<>();
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            rst.add(node.val);
            node = node.right;
        }
        return rst;
    }
    public void tree1(TreeNode node, List<Integer> rst){
        if(node == null)
            return;
        tree1(node, rst);
        rst.add(node.val);
        tree1(node.right, rst);
    }

    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node4.left = node5;
        node4.right = node6;
        AllElements allElements = new AllElements();
        allElements.getAllElements(node1, node4);

    }
    public TreeNode getNext(TreeNode node, Deque<TreeNode> stack){
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            return stack.pop();
        }
        return null;
    }
}
