package math;

import java.util.BitSet;

/**
 * Created by gouthamvidyapradhan on 21/03/2017.
 * Description:
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	int num = 10000000;
    	long begin = System.currentTimeMillis();
        System.out.println(new CountPrimes().countPrimes(num));
        long end = System.currentTimeMillis();
        System.out.println(countPrimeNum(num));
        long end2 = System.currentTimeMillis();
        System.out.println((end-begin)+" "+(end2-end));
    }

    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2) return 0;
        else if (n == 3) return 1;
        BitSet set = new BitSet();
        n = n - 1;
        int sqrt = (int) Math.sqrt(n);
        int count = n;
        for (int i = 2; i <= sqrt; i++) {
            if (!set.get(i)) {
                for (int j = 2; (i * j) <= n; j++) {
                    if (!set.get(i * j)) {
                        count--;
                        set.set(i * j);
                    }
                }
            }
        }
        return count - 1;
    }
    
    public static boolean isPrime(int n) {
    	if(n <= 3) return n>1;
    	for(int i = 2, len = (int) Math.sqrt(n); i <= len ; i++) {
    		if(n % i == 0) return false;
    	}
    	return true;
    }
    
    public static int countPrimeNum(int n) {
    	if(n <= 2) return 0;
    	if(n == 3) return 1;
    	int count = 0;
    	for(int i = 2; i < n; i++) {
    		if(isPrime(i)) {
    			count++;
//    			System.out.println(i+" "+count);
    		}
    	}
    	return count;
    }

}
