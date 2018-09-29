package tree;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 九月 18, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class KthLargest {
    private int k;
    private TreeNode root;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            addNode(num);
        }
    }

    private void addNode(int value){
        if(root == null)
        {
            root = new TreeNode(value);
            root.cnt = 1;
            return;
        }
        else{
            rescuit(root, value);
        }

    }
    private void rescuit(TreeNode node, int val){
        node.cnt++;
        if(val < node.val){
            if(node.left == null){
                node.left = new TreeNode(val);
                node.left.cnt = 1;
            }
            else{
                rescuit(node.left, val);
            }
        }
        else if(node.val == val){
            TreeNode n = new TreeNode(val);
            if(node.left == null){
                n.cnt = 1;
                node.left = n;
            }
            else{
                TreeNode left = node.left;
                n.cnt = left.cnt + 1;
                n.left = left;
                node.left = n;
            }
        }
        else{
            if(node.right == null){
                node.right = new TreeNode(val);
                node.right.cnt = 1;
            }
            else{
                rescuit(node.right, val);
            }
        }
    }

    public int add(int val) {
        addNode(val);
        return find(root, k);
    }

    private int find(TreeNode node, int cnt){
        if(node.cnt < cnt){
            return -1;
        }
        if(node.right != null){
            if(node.right.cnt >= cnt){
                return find(node.right, cnt);
            }
            cnt -= node.right.cnt;
        }
        if(cnt == 1){
            return node.val;
        }
        else
        {
            return find(node.left, cnt - 1);
        }
    }

    class TreeNode{
        int val;
        int cnt;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }

    }

    public static void main(String[] args)
    {
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));
    }
}
