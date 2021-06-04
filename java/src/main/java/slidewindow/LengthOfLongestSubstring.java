package slidewindow;

/**
 *
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 * @author liming
 * @version [版本号, 5月 06, 2021]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LengthOfLongestSubstring
{

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] chars = new int[128];
        int start =0, maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            start = Math.max(start, chars[c]);
            maxLen = Math.max(maxLen, i - start + 1);
            chars[c] = i + 1;
        }
        return maxLen;
    }
}
