/**
 * @author liming
 * @date 14-11-28 下午2:11
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p/>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
	public static ListNode deleteDuplicates_(ListNode head) {
		if(head==null) return null;
		ListNode FakeHead=new ListNode(0);
		FakeHead.next=head;
		ListNode pre=FakeHead;
		ListNode cur=head;
		while(cur!=null){
			while(cur.next!=null&&cur.val==cur.next.val){
				cur=cur.next;
			}
			if(pre.next==cur){
				pre=pre.next;
			}
			else{
				pre.next=cur.next;
			}
			cur=cur.next;
		}
		return FakeHead.next;
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode headNode = null,node = null,first = head,next = head.next;
		int count = 0;
		while(first != null){
			if(next == null){
				break;
			}
			if(first.val == next.val){
				count++;
			}
			else{
				if(count == 0){
					if(headNode == null){
						node = first;
						headNode = first;
					}
					else {
						node.next = first;
						node = first;
					}

				}else{
					count = 0;
				}
				first = next;
			}
			next = next.next;
		}
		if(count == 0 && first != headNode) {
			node.next = first;
			node = first;
		}
		if(node != null) {
			node.next = null;
		}

		return headNode;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node21 = new ListNode(2);
		ListNode node22 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node41 = new ListNode(4);
		ListNode node5 = new ListNode(4);

		node1.next = node11;
		node11.next = node12;
		node12.next = node2;
		node2.next = node21;
		node21.next = node22;
		node22.next = node3;
		node3.next = node4;
		node4.next = node41;
		node41.next = node5;

		ListNode head = deleteDuplicates(node1);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
