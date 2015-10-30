/**
* <p>Title: ReverseInteger.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ReverseInteger</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 下午8:46:41
 */
public class ReverseInteger {
	private static final int MAXDIV10 = Integer.MAX_VALUE / 10;
	private static final int MINDIV10 = Integer.MIN_VALUE / 10;
    public int reverse(int x) {
        int num = 0;
        while(x != 0){
        	int digit = x % 10;
        	if(num > MAXDIV10 || num < MINDIV10 || (num == MAXDIV10 && digit > 8) || (num == MINDIV10 && digit < -8))
        		return 0;
        	num = num * 10 + digit;
        	x /= 10;
        }
        return num;
    }
    
    public static void main(String[] args) {
    	ReverseInteger so = new ReverseInteger();
    	int[] tests = {100, 5, 0, 1394563459, -1344444447, 234829, 123456, Integer.MAX_VALUE, Integer.MIN_VALUE};
		for(int i = 0; i < tests.length; i ++){
			System.out.println(tests[i] + " : " + so.reverse(tests[i]));
		}
	}
}
