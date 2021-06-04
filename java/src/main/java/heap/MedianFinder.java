package heap;

import java.util.PriorityQueue;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 12, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MedianFinder
{
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((x, y) -> (y - x));
    boolean allEmpty = true;
    /** initialize your data structure here. */
    public MedianFinder() {
    }

    public void addNum(int num) {
        if(allEmpty){
            allEmpty = false;
            maxQueue.offer(num);
            return;
        }
        int maxTop = maxQueue.peek();
        if(num <=  maxQueue.peek()){
            maxQueue.offer(num);
            if(maxQueue.size() > minQueue.size() + 1){
                minQueue.offer(maxQueue.poll());
            }
        }
        else{/* if(num >= minQueue.peek()){*/
            minQueue.offer(num);
            if(minQueue.size() > maxQueue.size() + 1){
                maxQueue.offer(minQueue.poll());
            }
        }
       /* maxQueue.offer(num);
        minQueue.offer(maxQueue.poll());
        if(count % 2 == 0){
            maxQueue.offer(minQueue.poll());
        }*/
    }

    public double findMedian() {
        if(minQueue.size() > maxQueue.size()){
            return minQueue.peek();
        }
        if(minQueue.size() < maxQueue.size()){
            return maxQueue.peek();
        }
        return ((double)minQueue.peek() + maxQueue.peek())/2;
    }

    public static void main(String[] args)
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
    }
}
