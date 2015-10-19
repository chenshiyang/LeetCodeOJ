/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月15日
* @version jdk8.0
*/
package ugly_number;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月15日
 * @time 上午8:43:10
 */
public class Solution {
    public boolean isUgly(int num) {
        if(num < 1)
        	return false;//num must be a positive number.
        if(num == 1)
        	return true;// 1 is an ugly number.
        while(num != 0 && num % 5 == 0)
        	num /= 5;
        while(num != 0 && num % 3 == 0)
        	num /= 3;
        while(num != 0 && num% 2 == 0)
        	num /= 2;
        return num == 1;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		int[] test = {0, 1, 2, 3, 5, 7, 21, 22, 47, 192};
		boolean[] ans = {false, true, true, true, true, false, false, false, false, true};
		for(int i = 0; i < test.length; i ++)
			System.out.println(so.isUgly(test[i]) == ans[i]);
	}
}
