/**
* <p>Title: ReverseBits.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ReverseBits</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午2:41:04
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverseValue = 0, bit = 32;
        while(bit > 0){
        	bit --;
        	reverseValue <<= 1;
        	reverseValue += (n & 1);
        	n >>= 1;
        }
        return reverseValue;
    }
    
    public static void main(String[] args) {
		ReverseBits so = new ReverseBits();
		int[] test = {0, 43261596};
		for(int i = 0; i < test.length; i ++){
			System.out.println(test[i] + " " + so.reverseBits(test[i]));
		}
	}
}
