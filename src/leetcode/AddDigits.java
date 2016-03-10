/**
* <p>Title: AddDigits.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Mar 10, 2016
* @version version 1.0
*/
package leetcode;

import add_digits.Solution;

/**
 * <p>Title: AddDigits</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 10, 2016
 * @time 10:23:07 AM
 */
public class AddDigits {
    /**
    * https://en.wikipedia.org/wiki/Digital_root
    * @param num
    * @return
    */
    public int addDigits(int num) {
    	if(num < 10)
    		return num;
    	return num % 9 == 0? 9 : num % 9;
    }
    
    public static void main(String[] args) {
		AddDigits so = new AddDigits();
		int[] test = {5, 9, 18, 218, 999, 0};
		int[] ans = {5, 9, 9, 2, 9, 0};
		for(int i = 0; i < test.length; i ++){
			System.out.println(so.addDigits(test[i]) == ans[i]);
		}
	}
}
