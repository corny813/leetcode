package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 2+2+3=7  print all the possible combination sum for the target, unlimited number of times
 * Changed by wujunjie on 15/05/2018 
 * 
 * Created by pradhang on 3/14/2017.
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */
public class CombinationSum {
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] candidates = {2,3,5};//{2, 3, 6, 7};

        List<List<Integer>> result = new CombinationSum().combinationSum(candidates, 8);
        
        for(int i=0;i<result.size();i++){
        	for(int j=0;j<result.get(i).size();j++){
        		System.out.print(" "+result.get(i).get(j)+" ");
        	}
        	System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        doNext(0, result, candidates, target, subList);
        return result;
    }

    private void doNext(int i, List<List<Integer>> result, int[] candidates, int target, List<Integer> subArr) {
        if (target == 0) {
            List<Integer> subList = new ArrayList<>();
            for (int k = 0; k < subArr.size(); k++)
                subList.add(subArr.get(k));
            result.add(subList);
        } else if (target > 0) {
            for (int j = i; j < candidates.length; j++) {
                subArr.add(candidates[j]);
                doNext(j, result, candidates, target - candidates[j], subArr);
                subArr.remove(subArr.size() - 1);
            }
        }
    }
}
