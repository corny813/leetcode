package math;

/**
 * Changed by wujunjie on 28/05/2018
 * 
 * Created by gouthamvidyapradhan on 02/08/2017.
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {

    public static void main(String[] args) throws Exception {
        System.out.println(new AddDigits().addDigits(38));
    }

    public int addDigits(int num) {//num = 9*(something) + remain; abc=100a+10b+c=a+b+c+(99a+9b)
        if (num == 0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }

}
