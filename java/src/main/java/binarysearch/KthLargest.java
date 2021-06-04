package binarysearch;

/**
 * 数据流中的第K大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 *
 * @author liming
 * @version [版本号, 5月 26, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class KthLargest
{
    TreeNodeNum root;
    int k = 0;
    class TreeNodeNum
    {
        public int rightNum = 0;
        public int leftNum = 0;
        public int val;
        public TreeNodeNum left;
        public TreeNodeNum right;
        public TreeNodeNum(int x) { val = x; }
    }
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i : nums){
            insert(i, root);
        }
    }
    public void insert(int val, TreeNodeNum root){
        if(root == null){
            this.root = new TreeNodeNum(val);
            return;
        }
        if(root.val > val){
            if(root.left == null){
                root.left = new TreeNodeNum(val);
            }
            else{
                insert(val, root.left);
            }
            root.leftNum++;
        }
        else{
            if(root.right == null){
                root.right = new TreeNodeNum(val);
            }
            else if(root.val < val){
                insert(val, root.right);
            }
            else{
                TreeNodeNum tmp = new TreeNodeNum(val);
                tmp.rightNum = root.rightNum;
                tmp.right = root.right;
                root.right = tmp;
            }
            root.rightNum++;
        }
    }

    public int search(TreeNodeNum node, int k){
        if(node.rightNum == k - 1){
            return node.val;
        }
        else if(node.rightNum > k - 1){
            return search(node.right, k);
        }
        else{
            return search(node.left, k - node.rightNum - 1);
        }
    }

    public int add(int val) {
        insert(val, root);
        return search(root, this.k);
    }

    public static void main(String[] args)
    {
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.search(kthLargest.root, 3));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
