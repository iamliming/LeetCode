package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 5月 12, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TopKFrequent
{
    public int[] topKFrequent(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
        {
            map.compute(i, (key, val) -> {
                if (val == null)
                    return 1;
                return ++val;
            });
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((k1, k2) -> {
            return k1.getValue() - k2.getValue();
        });
        for (Map.Entry<Integer, Integer> set : map.entrySet())
        {
            if (queue.size() < k)
            {
                queue.offer(set);
            }
            else
            {
                if (queue.peek().getValue() < set.getValue())
                {
                    queue.poll();
                    queue.offer(set);
                }
            }
        }
        int[] rst = new int[k];
        Map.Entry<Integer, Integer> set;
        int i = 0;
        while ((set = queue.poll()) != null)
        {
            rst[i++] = set.getKey();
        }
        return rst;
    }

    public List<String> topKFrequent(String[] words, int k)
    {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
        {
            map.compute(word, (key, val) -> {
                if (val == null)
                    return 1;
                else
                {
                    return ++val;
                }
            });
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> {
            if (o1.getValue() == o2.getValue())
            {
                return o2.getKey().compareTo(o1.getKey());
            }
            return o1.getValue() - o2.getValue();
        });
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (priorityQueue.size() < k)
            {
                priorityQueue.offer(entry);
            }
            else
            {
                Map.Entry<String, Integer> topEntry = priorityQueue.peek();
                if (topEntry.getValue() < entry.getValue() ||
                    (topEntry.getValue() == entry.getValue() && topEntry.getKey().compareTo(entry.getKey()) > 0))
                {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }
            }
        }
        List<String> rst = new ArrayList<>(priorityQueue.size());
        Map.Entry<String, Integer> entry = null;
        while ((entry = priorityQueue.poll()) != null)
        {
            rst.add(0, entry.getKey());
        }
        return rst;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(nums, 2);
        System.out.println("the".hashCode() < "tze".hashCode());
//["jnoqzdute","fvvdtpnzx","hhqpvvt","nkpllqzjzp"]

        System.out.println("jnoqzdute".hashCode() < "fvvdtpnzx".hashCode());
        System.out.println("jnoqzdute".charAt(0) < "fvvdtpnzx".charAt(0));
        System.out.println(topKFrequent.topKFrequent(new String[] {"plpaboutit", "jnoqzdute", "sfvkdqf", "mjc",
            "nkpllqzjzp", "foqqenbey", "ssnanizsav", "nkpllqzjzp", "sfvkdqf", "isnjmy", "pnqsz", "hhqpvvt", "fvvdtpnzx",
            "jkqonvenhx", "cyxwlef", "hhqpvvt", "fvvdtpnzx", "plpaboutit", "sfvkdqf", "mjc", "fvvdtpnzx", "bwumsj",
            "foqqenbey", "isnjmy", "nkpllqzjzp", "hhqpvvt", "foqqenbey", "fvvdtpnzx", "bwumsj", "hhqpvvt", "fvvdtpnzx",
            "jkqonvenhx", "jnoqzdute", "foqqenbey", "jnoqzdute", "foqqenbey", "hhqpvvt", "ssnanizsav", "mjc",
            "foqqenbey", "bwumsj", "ssnanizsav", "fvvdtpnzx", "nkpllqzjzp", "jkqonvenhx", "hhqpvvt", "mjc", "isnjmy",
            "bwumsj", "pnqsz", "hhqpvvt", "nkpllqzjzp", "jnoqzdute", "pnqsz", "nkpllqzjzp", "jnoqzdute", "foqqenbey",
            "nkpllqzjzp", "hhqpvvt", "fvvdtpnzx", "plpaboutit", "jnoqzdute", "sfvkdqf", "fvvdtpnzx", "jkqonvenhx",
            "jnoqzdute", "nkpllqzjzp", "jnoqzdute", "fvvdtpnzx", "jkqonvenhx", "hhqpvvt", "isnjmy", "jkqonvenhx",
            "ssnanizsav", "jnoqzdute", "jkqonvenhx", "fvvdtpnzx", "hhqpvvt", "bwumsj", "nkpllqzjzp", "bwumsj",
            "jkqonvenhx", "jnoqzdute", "pnqsz", "foqqenbey", "sfvkdqf", "sfvkdqf"
        },1));
    }
}
