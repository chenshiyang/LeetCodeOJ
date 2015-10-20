/**
* <p>Title: NumberOfOneBits.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: NumberOfOneBits</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 上午11:42:35
 */
public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
        	count ++;
        	n = n & (n - 1);
        }
        return count;
    }
    
    public static void main(String[] args) {
    	NumberOfOneBits so = new NumberOfOneBits();
    	int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    	for(int i = 0; i < test.length; i ++){
    		System.out.println(i + " " + so.hammingWeight(i));
    	}
	}
}
