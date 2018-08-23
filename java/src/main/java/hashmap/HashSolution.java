package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HashSolution
{
    public boolean isValidSudoku(char[][] board)
    {
        return false;
    }

    /**
     * Remove Duplicates from Sorted Array II
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums)
    {
        int slow = 0, fast = 0, same = 0;
        while (fast < nums.length)
        {
            if (nums[slow] != nums[fast])
            {
                if (same == 1)
                {
                    slow++;
                }
                else if (same >= 2)
                {
                    nums[slow + 1] = nums[slow];
                    slow = slow + 2;
                }
                nums[slow] = nums[fast];
                same = 1;
            }
            else
            {
                same++;
            }
            fast++;
        }
        if (same >= 2)
        {
            nums[slow + 1] = nums[slow];
            slow++;
        }
        return slow + 1;
    }

    /**
     * 76. Minimum Window Substring
     */
    public String minWindows(String s, String t)
    {
        if (s == null || s.length() < t.length() || s.length() == 0)
        {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int count = t.length(), left = 0, right = 0, minLeft = -1, minLen = Integer.MAX_VALUE;
        for (Character c : t.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while (right < s.length())
        {
            char c = s.charAt(right);
            if (map.containsKey(c))
            {
                int val = map.get(c) - 1;
                map.put(c, val);
                if (val >= 0)
                {
                    count--;
                }
                while (count == 0)
                {
                    char cc = s.charAt(left);
                    if (map.containsKey(cc))
                    {
                        if (right - left + 1 < minLen)
                        {
                            minLeft = left;
                            minLen = right - left + 1;
                        }
                        int v = map.get(cc) + 1;
                        map.put(cc, v);
                        if (v > 0)
                        {
                            count++;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        if (minLeft == -1)
        {
            return "";
        }
        return s.substring(minLeft, minLeft + minLen);
    }

    public String minWindow(String s, String t)
    {
        if (s == null || s.length() < t.length() || s.length() == 0)
        {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray())
        {
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++)
        {
            if (map.containsKey(s.charAt(right)))
            {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0)
                {
                    count++;
                }
                while (count == t.length())
                {
                    if (right - left + 1 < minLen)
                    {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left)))
                    {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0)
                        {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length())
        {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }

    /**
     * 30. Substring with Concatenation of All Words
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
        {
            return rst;
        }
        int len = words[0].length(), count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
        {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> subMap = new HashMap<>();

        for(int i = 0; i < len; i++)
        {
            int slow = i, fast = i;
            subMap.clear();
            count = 0;
            while (fast < s.length())
            {
                int fastEnd = fast + len;
                if (fastEnd >= s.length())
                {
                    break;
                }
                String subStr = s.substring(fast, fastEnd);
                if (map.containsKey(subStr))
                {
                    //默认加一
                    int val = subMap.getOrDefault(subStr, 0) + 1;
                    //每个单词小于上限
                    if (val <= map.get(subStr))
                    {
                        count++;
                        subMap.put(subStr, val);
                        //如果是第一个单词,将slow置到fast位置
                        if (count == 1)
                        {
                            slow = fast;
                        }
                    }
                    //单词大于上限,start要往前,直到删除第一个subStr位置
                    else
                    {
                        //                        subMap.clear();
                        //                        count = 0;
                        while (slow < fast)
                        {
                            String sSub = s.substring(slow, slow + len);
                            //第一个subStr
                            if (sSub.equals(subStr))
                            {
                                subMap.put(subStr, val - 1);
                                slow += len;
                                break;
                            }
                            else
                            {
                                if (subMap.containsKey(sSub) && subMap.get(sSub) > 0)
                                {
                                    subMap.put(sSub, subMap.get(sSub) - 1);
                                    count--;
                                }
                                slow += len;
                            }
                        }
                    }
                }
                else
                {
                    //如果单词没在words列表中，直接清空，重新开始
                    subMap.clear();
                    slow = fast;
                    count = 0;
                }
                if (count == words.length)
                {
                    rst.add(slow);
                }

                fast += len;
            }
        }
        return rst;
    }
}
