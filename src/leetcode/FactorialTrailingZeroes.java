/**
* <p>Title: FactorialTrailingZeroes.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: FactorialTrailingZeroes</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午3:23:16
 */
public class FactorialTrailingZeroes {

	//Since 0 only company with 5*2 So only need to count the volume of 5 factor. (because 2 always enough)
	//
	//So.. 100! 's zero has => floor(100/5) + floor(100/25) = floor(100/5) + floor((100/5)/5)
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0){
        	n /= 5;
        	count += n;
        }
        return count;
    }
    
    public static void main(String[] args) {
		FactorialTrailingZeroes so = new FactorialTrailingZeroes();
		int[] test = {6, 12, 17, 20};
		for(int i = 0; i < test.length; i ++){
			System.out.println(test[i] + " " + so.trailingZeroes(test[i]));
		}
	}
}
