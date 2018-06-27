/**
 * @author liming
 * @date 14-11-20 下午3:36
 * 每个node保存当前节点的最小值和当前值
 */
public class MinStackWithoutStack {
	private StackNode top;
	private int size = 0;
	public int size(){
		return size;
	}

	/**
	 * Push element x onto stack.
	 * @param x
	 */
	public void push(int x){
		size++;
		StackNode node = new StackNode();
		node.setValue(x);
		if(top == null){
			top = node;
			node.setMin(x);
		}
		else{
			node.setNext(top);
			if(top.getMin()>x){
				node.setMin(x);
			}
			else{
				node.setMin(top.getMin());
			}
			top = node;
		}
	}

	/**
	 * Removes the element on top of the stack.
	 */
	public void pop() {
		size--;
		if(top == null){
			return;
		}
		if(top.getNext() != null) {
			top = top.getNext();
		}
		else{
			top = null;
		}
	}

	/**
	 * Get the top element.
	 * @return
	 */
	public int top() {
		return top == null ? null : top.getValue();
	}

	/**
	 * Retrieve the minimum element in the stack.
	 * @return
	 */
	public int min() {
		return top == null ? null : top.getMin();
	}

	public static void main(String[] args) {
		MinStackWithoutStack stack = new MinStackWithoutStack();
		stack.push(50);
		stack.push(100);
		stack.push(80);
		stack.push(90);
		stack.push(70);
		stack.push(100);
		stack.push(60);
		stack.push(-10);

		while(stack.size() > 0) {
			System.out.print("size:"+stack.size());
			System.out.print(",top:" + stack.top());
			System.out.print(",min:" + stack.min());
			stack.pop();
			System.out.println();
		}
	}
}
class StackNode{
	int value;
	int min;
	StackNode next;

	public int getValue() {

		return value;
	}

	public void setValue(int value) {

		this.value = value;
	}

	public int getMin() {

		return min;
	}

	public void setMin(int min) {

		this.min = min;
	}

	public StackNode getNext() {

		return next;
	}

	public void setNext(StackNode next) {

		this.next = next;
	}

}
