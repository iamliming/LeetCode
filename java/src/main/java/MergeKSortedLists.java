import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liming
 * @date 14-11-26 下午4:48
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {

	/**
	 * 使用java远程优先级队列PriorityQueue
	 *  1.优先级队列 ----优先级最高的先出队列
	 *  2.堆--  完全二叉树,父节点 < 子节点
	 *          n个元素序列{k1,k2...ki...kn},当且仅当满足下列关系时称之为堆：
	 *          (ki <= k2i,ki <= k2i+1)或者(ki >= k2i,ki >= k2i+1), (i = 1,2,3,4...n/2)
	 * 优先级队列插入一个节点的时间复杂度是O(logN)
	 * 删除一个元素,会shiftup 复杂度也是logN,和树的层数有关系
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

		ListNode node1 = new ListNode(1);
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
		}
	}
}
