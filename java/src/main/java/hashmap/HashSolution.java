package hashmap;

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
    public boolean isValidSudoku(char[][] board) {
        return false;
    }

    /**
     * Remove Duplicates from Sorted Array II
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0, same = 0;
        while(fast < nums.length){
            if(nums[slow] != nums[fast]){
                if(same == 1){
                    slow++;
                }
                else if(same >= 2){
                    nums[slow+1] = nums[slow];
                    slow = slow+2;
                }
                nums[slow] = nums[fast];
                same = 1;
            }else
            {
                same++;
            }
            fast++;
        }
        if(same>=2){
            nums[slow+1] = nums[slow];
            slow++;
        }
        return slow+1;
    }
}
