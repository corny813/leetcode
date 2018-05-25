package bit_manipulation;

/**
 * Problem: calculate the Hamming distance
 * Changed by wujunjie on 24/05/2018
 * 
 * Created by gouthamvidyapradhan on 16/12/2017.
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 <= x, y < 2^31.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 

 The above arrows point to positions where the corresponding bits are different.

 Solution O(1): XOR (x, y) and count the number of bits set

 */
public class HammingDistance {

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
    	hammingDistance(1,4);
    }

    public static int hammingDistance(int x, int y) {
        int z = (x ^ y);
        int count = 0;
        for(int i = 0; i < 32; i++){//count the number of 1 on 31bits: positive integer
            if((z & (1 << i)) > 0){
                count++;
            }
//        	if(( (z >> i) & 1) > 0) count++;
        }
        System.out.println(count+" "+Integer.MAX_VALUE);//2 147 483 647 (2.1 billion)
        return count;
    }
}
