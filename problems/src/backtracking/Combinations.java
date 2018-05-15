package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: List all possible combinations of C(n,k)= n!/((n-k)!*k!)
 * Changed by wujunjie on 14/05/2018
 * 
 * Created by pradhang on 3/8/2017.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {

    public static void main(String[] args) throws Exception {
    	new Combinations().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        combines(n, k, 1, tmp, result);
        
        for(int i=0; i<result.size();i++){
        	for(int j=0;j<result.get(i).size();j++){
        		System.out.print(" "+result.get(i).get(j)+" ");
        	}
        	System.out.println();
        }
        return result;
    }

    public void combines(int n, int k, int start, ArrayList<Integer> comb, 
    		List<List<Integer>> result) {
    	 
    	if(comb.size() == k) {
    		result.add(new ArrayList<Integer>(comb));//result.add(comb) is wrong: empty result
    	}else{
    		for(int i = start; i <= n; i++) {
    			comb.add(i);
    			combines(n, k, i+1, comb, result);
    			comb.remove(comb.size()-1);
    		}
    	}
    }
}
