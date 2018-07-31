package in50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @author liming
 * @version [版本号, 七月 11, 2018]
 * @see <a href="https://leetcode.com/problems/combination-sum/description/">39CominationSum</a>
 * @since [产品/模块版本]
 */
public class _39CombinationSum
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Arrays.sort(candidates);
        combination(rst, item, 0, candidates, target);
        return rst;
    }
    private void combination(List<List<Integer>> rst, List<Integer> item, int idx, int[] candidates, int target){
        for(int i = idx; i < candidates.length; i++){
            int j = candidates[i];
            if(j < target){
                List<Integer> clone = new ArrayList<>(item);
                clone.add(j);
                combination(rst,clone,i,candidates,target-j);
            }
            else if(j == target){
                item.add(j);
                rst.add(item);
                return;
            }
            else{
                return;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Arrays.sort(candidates);
        combination2(rst, item, 0, candidates, target);
        return rst;
    }

    private void combination2(List<List<Integer>> rst, List<Integer> item, int idx, int[] candidates, int target){
        for(int i = idx; i < candidates.length; i++){
            int j = candidates[i];
            if(j < target){
                List<Integer> clone = new ArrayList<>(item);
                clone.add(j);
                combination2(rst,clone,i+1,candidates,target-j);
            }
            else if(j == target){
                item.add(j);
                rst.add(item);
                return;
            }
            else{
                return;
            }
        }
    }


}
