package bit_manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: print n bit gray code
 * Changed by wujunjie on 24/05/2018
 * 
 * Created by gouthamvidyapradhan on 16/03/2017.
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<Integer> result = new GrayCode().grayCode(3);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int tmp = (1<<n) - 1;//left move n bit for 1; tmp=2^n-1;
        for (int i = 0; i <= tmp; i++) {
        	System.out.println(n+" "+i+" "+(i^(i>>1)));
        	result.add(i ^ (i >> 1));
        }
        return result;
    }
}
