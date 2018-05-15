package array;

/**
 * Problem: Check the flowerbed can place n more flower, if can return true else return false
 * Changed by wujunjie on 14/05/2018
 * 
 * Created by gouthamvidyapradhan on 10/06/2017.
 * Accepted
 * <p>
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlowers {
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] n = {1, 0, 0, 0, 1};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(n, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

    	int[] arr = new int[flowerbed.length + 3];
        
        for(int i = 0,j=1; i < flowerbed.length; i++) {
            arr[j++] = flowerbed[i];
        }
        arr[arr.length-1] = 1;//put a '1' at last
        
        int count = 0;
        int total = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) count++;
            else{
                if(count % 2 == 0) {
                    total += count/2 - 1;
                }else{
                    total += count/2;
                }
                count = 0;
            }
        }
        return total>=n;
    }
}
