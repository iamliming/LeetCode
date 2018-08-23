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
}
