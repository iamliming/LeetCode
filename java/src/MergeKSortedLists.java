import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liming
 * @version 2.2.4
 * @date 14-11-26 下午4:48
 * @id $Id$
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {

	/**
	 * 使用java远程优先级队列PriorityQueue
	 * 优先级队列插入一个节点的时间复杂度是O(logN)
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists(List<ListNode> lists) {

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
			@Override public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail=dummy;

		for (ListNode node:lists)
			if (node!=null)
				queue.add(node);

		while (!queue.isEmpty()){
			tail.next=queue.poll();
			tail=tail.next;

			if (tail.next!=null)
				queue.add(tail.next);
		}
		return dummy.next;
	}

	public static void main(String[] args) {

		PriorityQueue queue = new PriorityQueue();
		queue.add(2);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(3);
		System.out.println(queue);

		PriorityQueue<ListNode> queue1 = new PriorityQueue(6,new Comparator<ListNode>(){
			@Override public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}});
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node3 = new ListNode(3);
		queue1.add(node2);
		queue1.add(node4);
		queue1.add(node5);
		queue1.add(node6);
		queue1.add(node7);
		queue1.add(node3);
		System.out.println(queue1);


		/*ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node11 = new ListNode(11);
		ListNode node23 = new ListNode(13);
		ListNode node32 = new ListNode(12);
		ListNode node14 = new ListNode(24);
		ListNode node21 = new ListNode(21);
		ListNode node33 = new ListNode(20);

		node1.next = node11;
		node11.next = node14;

		node2.next = node21;
		node21.next = node23;

		node3.next = node32;
		node32.next = node33;

		List<ListNode> nodes = new ArrayList();

		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);

		ListNode rst = mergeKLists(nodes);
		while(rst != null){
			System.out.println(rst.val);
			rst = rst.next;
		}*/
	}
}
