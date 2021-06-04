package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public boolean isSymmetric(TreeNode root)
    {
        Deque<TreeNode> oneStack = new LinkedList();
        Deque<TreeNode> secStack = new LinkedList();
        oneStack.push(root);
        while (isNotEmpty(oneStack) || isNotEmpty(secStack))
        {
            if (isNotEmpty(oneStack))
            {
                while (isNotEmpty(oneStack))
                {
                    TreeNode nodeLeft = oneStack.poll();
                    if (!isNotEmpty(oneStack))
                    {
                        if (nodeLeft != null)
                        {
                            secStack.push(nodeLeft.right);
                            secStack.push(nodeLeft.left);
                        }
                    }
                    else
                    {
                        TreeNode nodeRight = oneStack.pop();
                        if (nodeLeft == null && nodeRight == null)
                        {
                            continue;
                        }
                        else if (nodeLeft != null && nodeRight != null)
                        {
                            if (nodeLeft.val != nodeRight.val)
                            {
                                return false;
                            }
                            secStack.push(nodeRight.right);
                            secStack.push(nodeRight.left);
                            secStack.push(nodeLeft.right);
                            secStack.push(nodeLeft.left);
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
            else
            {
                while (isNotEmpty(secStack))
                {
                    TreeNode nodeLeft = secStack.poll();
                    if (!isNotEmpty(secStack))
                    {
                        if (nodeLeft != null)
                        {
                            oneStack.push(nodeLeft.right);
                            oneStack.push(nodeLeft.left);
                        }
                    }
                    else
                    {
                        TreeNode nodeRight = secStack.pop();
                        if (nodeLeft == null && nodeRight == null)
                        {
                            continue;
                        }
                        else if (nodeLeft != null && nodeRight != null)
                        {
                            if (nodeLeft.val != nodeRight.val)
                            {
                                return false;
                            }
                            oneStack.push(nodeRight.right);
                            oneStack.push(nodeRight.left);
                            oneStack.push(nodeLeft.right);
                            oneStack.push(nodeLeft.left);
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isNotEmpty(Deque deque)
    {
        return deque != null && deque.size() != 0;
    }

    public TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return null;
        return bst(0, nums.length - 1, nums);
    }

    private TreeNode bst(int start, int end, int[] nums)
    {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        if ((start + end) % 2 > 0)
            mid++;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(start, mid - 1, nums);
        node.right = bst(mid + 1, end, nums);
        return node;
    }

    /**
     * 230. Kth Smallest Element in a BST
     * DescriptionHintsSubmissionsDiscussSolution
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     * <p>
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * Output: 1
     * Example 2:
     * <p>
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * Output: 3
     * Follow up:
     * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
     * How would you optimize the kthSmallest routine?
     *
     * @param node
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k)
    {
        count = k;
        preorder(root);
        return kth;
    }

    int count, kth;

    private void preorder(TreeNode node)
    {
        if (node.left != null)
            preorder(node.left);
        if (count == 0)
            return;
        if (count == 1)
        {
            kth = node.val;
            return;
        }
        count--;
        if (node.right != null)
            preorder(node.right);
    }

    /**
     * 94. Binary Tree Inorder Traversal
     * 递归法或者迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> rst = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty())
        {
            while (node != null && node.left != null)
            {
                stack.push(node);
                node = node.left;
            }
            if (node == null)
            {
                node = stack.pop();
            }
            rst.add(node.val);
            node = node.right;
        }
        return rst;
    }

    private void traversalHelp(TreeNode node, List<Integer> rst)
    {
        if (node.left != null)
        {
            traversalHelp(node.left, rst);
        }
        rst.add(node.val);
        if (node.right != null)
            traversalHelp(node.right, rst);
    }

    /**
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (inorder == null || inorder.length == 0)
            return null;
        return doBuild(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode doBuild(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder)
    {
        TreeNode node = new TreeNode(preorder[preStart]);
        int inNum = -1;
        for (int i = inStart; i <= inEnd; i++)
        {
            if (inorder[i] == preorder[preStart])
            {
                inNum = i;
                break;
            }
        }
        //left Tree
        if (inNum != inStart)
        {
            node.left = doBuild(preStart + 1, inStart, inNum - 1, preorder, inorder);
        }
        if (inNum != inEnd)
        {
            node.right = doBuild(preStart + inNum - inStart + 1, inNum + 1, inEnd, preorder, inorder);
        }
        return node;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(s.val == t.val){if(sameTree(s, t)) return true;}
        else{
            if(isSubtree(s.left, t)) return true;
            if(isSubtree(s.right, t)) return true;
        }
        return false;
    }

    private boolean sameTree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null || s.val != t.val) return false;
        return sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }

}
