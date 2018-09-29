package listnode;

import node.ListNode;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 16, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ListNodeSolution
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        ListNode top = null, tail = null;
        for (int i = 1; i <= m - 1; i++)
        {
            if (top == null)
                top = head;
            else
                top = top.next;
        }
        ListNode curr = top.next, prev = null, next = null;
        for (int i = 0; i < n - m; i++)
        {
            next = curr.next;
            curr.next = prev;
            if (i == n - m - 1)
            {
                top.next.next = curr.next;
                top.next = curr;
                break;
            }
            prev = curr;
            curr = next;
        }
        return head;
    }

    /**
     * 148. Sort List
     * Sort a linked list in O(n log n) time using constant space complexity.
     * <p>
     * Example 1:
     * <p>
     * Input: 4->2->1->3
     * Output: 1->2->3->4
     * Example 2:
     * <p>
     * Input: -1->5->3->4->0
     * Output: -1->0->3->4->5
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head)
    {
        if(head == null || head.next == null) return head;
        ListNode mid = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode rNode = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rNode);

        if(left != null && right != null)
            return merge(left, right);
        else if(left != null)
            return left;
        else
            return right;
    }

    private ListNode merge(ListNode left, ListNode right)
    {
        ListNode rootPrev = new ListNode(-1);
        ListNode prev = rootPrev;
        while (left != null && right !=null){
            if(left.val <= right.val){
                prev.next = left;
                prev = left;
                left = left.next;
            }
            else{
                prev.next = right;
                prev = right;
                right = right.next;
            }
        }
        if(left != null){
            prev.next = left;
        }
        if(right != null){
            prev.next = right;
        }
        return rootPrev.next;
    }
}
