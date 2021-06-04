package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 13, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MincostToHireWorkers
{
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; ++i)
        {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);

        int sumQuality = 0;
        double rst = Double.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>(K-1, (o1,o2) -> {return o2-o1;});
        for(int i= 0; i < n; i++){
            Worker worker = workers[i];
            if(i < K-1){
                sumQuality+= worker.quality;
                queue.offer(worker.quality);
            }
            else{
                rst = Math.min(rst, worker.ratio() * sumQuality + worker.wage);
                queue.offer(worker.quality);
                sumQuality += worker.quality;
                sumQuality -= queue.poll();
            }
        }

        return rst;
    }
    class Worker implements Comparable<Worker> {
        public int quality, wage;
        public Worker(int q, int w) {
            quality = q;
            wage = w;
        }

        public double ratio() {
            return (double) wage / quality;
        }

        public int compareTo(Worker other) {
            return Double.compare(ratio(), other.ratio());
        }
    }

    public static void main(String[] args)
    {
        int[] qu = new int[]{10,20,5};
        int[] wage = new int[]{70,50,30};
        MincostToHireWorkers workers = new MincostToHireWorkers();
        System.out.println(workers.mincostToHireWorkers(qu, wage, 2));
    }

}
