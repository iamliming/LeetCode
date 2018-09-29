package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 七月 25, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BackTrackSolution
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        backtrack(nums, rst, new ArrayList<>(nums.length), new boolean[nums.length]);
        return rst;
    }

    private void backtrack(int[] nums, List<List<Integer>> rst, List<Integer> list, boolean[] visit)
    {
        for (int i = 0; i < nums.length; i++)
        {
            if (visit[i])
            {
                continue;
            }
            if(visit[i + 1])
            visit[i] = true;
            list.add(nums[i]);
            if (list.size() == nums.length)
            {
                rst.add(new ArrayList(list));
            }
            else
            {
                backtrack(nums, rst, list, visit);
            }
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }

    /**
     * 79. Word Search
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;
        char c = word.charAt(0);
        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == c){
                    if(backtrack(board, word, 0, flag, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, boolean[][] flag, int i, int j){
        if(flag[i][j]){
            return false;
        }
        char ac = word.charAt(idx);
        char bc = board[i][j];

        if(ac == bc){
            if(idx == word.length() - 1){
                return true;
            }
            flag[i][j]= true;
            if(i-1>=0){
                if(backtrack(board, word, idx+1, flag, i-1, j)){return true;}
            }
            if(i+1<board.length){
                if(backtrack(board, word, idx+1, flag, i+1, j)){return true;}
            }
            if(j-1>=0){
                if(backtrack(board, word, idx+1, flag, i, j - 1)){return true;}
            }
            if(j+1<board[0].length){
                if(backtrack(board, word, idx+1, flag, i, j + 1)){return true;}
            }
            flag[i][j] = false;
        }
        return false;
    }
}
