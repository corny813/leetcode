package array;

/**
 * Problem: Find the first missing positive
 * Changed by wujunjie on 15/05/2018
 * 
 * Created by gouthamvidyapradhan on 24/06/2017.
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    private int L;

    public static void main(String[] args) throws Exception {
        int[] nums = {1, 3, 5, 9};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
        System.out.println(firstMissPositive(nums));
    }

    //same like counting sort
    public static int firstMissPositive(int[] nums) {
    	if(nums==null || nums.length<1) return 1;
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i]>0 && nums[i]-1<nums.length && nums[i]!=nums[nums[i]-1]) {
    			int tmp = nums[nums[i]-1];
    			nums[nums[i]-1] = nums[i];
    			nums[i] = tmp;
    			i--;
    		}
    	}
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i]!=i+1) return i+1;
    	}
    	
    	return nums.length + 1;
    }
    
    public int firstMissingPositive(int[] nums) {
        L = nums.length;
        for (int i = 0; i < L; i++) {
            if (nums[i] > 0 && nums[i] <= L && nums[i] != i + 1) {
                int v = nums[i];
                nums[i] = -1;
                replace(v, nums);
            }
        }

        for (int i = 0; i < L; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return L + 1;
    }

    private void replace(int i, int[] nums) {
        if (i > 0 && i <= L && i != nums[i - 1]) {
            int v = nums[i - 1];
            nums[i - 1] = i;
            replace(v, nums);
        }
    }

}
