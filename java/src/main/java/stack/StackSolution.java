package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 八月 02, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StackSolution
{
    /**
     * 84. Largest Rectangle in Histogram
     * <p>
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find
     * the area of largest rectangle in the histogram.
     *
     * 分治算法，某个矩形能形成的最大面积，左边界右边界都要比它小；
     * 维持一个升序栈,进栈的数据判断是否大于栈顶，是的情况直接进栈，继续找下个数；否的情况我们就找到了栈顶矩形的左边界和右边界，
     *  计算这个最大值后，将该矩形出栈
     *  最后，压入一个0的栈数据，索引为height.length  计算栈中未计算的矩形最大面积，同时出栈
     *  最后的栈是空的，每个矩形的所能形成的最大面积都已经计算过
     *
     *
     * @param height
     * @return
     */
    public int largestRectangleArea(int[] height)
    {
        int maxArea = 0, i = 0, h = 0;
        if(height == null || height.length == 0){
            return maxArea;
        }
        Deque<Integer> indexStack = new LinkedList<>();
        while(i <= height.length){
            h = i == height.length ? 0:height[i];
            if(indexStack.isEmpty() || height[indexStack.peekLast()] < h){
                indexStack.push(i);
                i++;
            }
            else{
                int tp = indexStack.pop();
                maxArea = Math.max(maxArea, tp*(indexStack.isEmpty() ? i : (i - indexStack.peekLast()- 1)));
            }
        }
        return maxArea;

    }
}
