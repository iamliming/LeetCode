import java.util.Stack;

/**
 * @author liming
 * @version 2.2.4
 * @date 14-11-20 下午12:38
 *
 * 有下列数据
 * 100 80 90 70 压入这个栈
 * push的是 数据与min的差值
 *
 *min:
 * ----------------------------------------------
 *  100-->80-->80-->70
 *  ----------------------------------------------
 *  stack
 *  ---------------------------------------------
 *  0|-20|10|-10
 *
 */
public class MinStackWithStack {
	long min;
	private Stack<Long> stack;

	public MinStackWithStack() {
		this.stack = new Stack<>();
	}

	/**
	 * Push element x onto stack.
	 * @param x
	 */
	public void push(int x) {
		if(stack.isEmpty()){
			stack.push(0l);
			min = x;
		}else{
			stack.push(x - min);
			if(x<min){
				min = x;
			}
		}
	}

	/**
	 * Removes the element on top of the stack.
	 */
	public void pop() {
		if(stack.isEmpty())
			return;
		else{
			long gap = stack.pop();
			if(gap < 0){
				min -= gap;
			}
		}
	}

	/**
	 * Get the top element.
	 * @return
	 */
	public int top() {
		long gap = stack.peek();
		if(gap < 0){
			return (int)min;
		}
		else{
			return (int)(gap + min);
		}
	}

	public int size(){
		return stack.size();
	}

	/**
	 * Retrieve the minimum element in the stack.
	 * @return
	 */
	public int min() {
		return (int)min;
	}

	public static void main(String[] args) {
		MinStackWithStack stack = new MinStackWithStack();
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
