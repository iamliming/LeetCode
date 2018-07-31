package stack;

/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * @author liming
 * @version [版本号, 七月 30, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MinStack
{
    int[] elements;

    /**
     * initialize your data structure here.
     */
    public MinStack()
    {
        this.elements = new int[0];
    }

    public void push(int x)
    {
        System.arraycopy(elements, 0, elements, 1, elements.length);
        elements[0] = x;
    }

    public void pop()
    {

    }

    public int top()
    {
        return elements[0];
    }

    public int getMin()
    {
        return 0;
    }

    public static void main(String[] args)
    {
        MinStack stack = new MinStack();
        stack.push(1);
    }
}
