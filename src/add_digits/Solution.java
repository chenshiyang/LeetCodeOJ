/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月15日
* @version jdk8.0
*/
package add_digits;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月15日
 * @time 上午9:18:51
 */
public class Solution {
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
		Solution so = new Solution();
		int[] test = {5, 9, 18, 218, 999, 0};
		int[] ans = {5, 9, 9, 2, 9, 0};
		for(int i = 0; i < test.length; i ++){
			System.out.println(so.addDigits(test[i]) == ans[i]);
		}
	}
}
