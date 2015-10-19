/**
* <p>Title: PowerOfTwo.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月17日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: PowerOfTwo</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月17日
 * @time 下午12:34:32
 */
public class PowerOfTwo {
	//solution 1: 一直除2，直到不能被2整除， 若商为1，则是2的整数次幂，否则不是。
/*    public boolean isPowerOfTwo(int n) {
    	if(n < 1) return false;
        while(n % 2 == 0){
        	n /= 2;
        }
        if(n == 1)
        	return true;
        else
        	return false;
    }*/
    
    //solution 2: 若n是2的整数次幂，则n的二进制表示只有最高位为1，其他位为0，
    //且n - 1的二进制表示恰好相反，最高位为0，其他位为1.
    // 即 n & (n - 1) == 0, n > 0
    public boolean isPowerOfTwo(int n){
    	return (n > 0 && ((n & (n - 1)) == 0));
    }
    
    public static void main(String[] args) {
		PowerOfTwo pot = new PowerOfTwo();
		for(int i = -100; i < 10000; i ++){
			if(pot.isPowerOfTwo(i))
				System.out.println(i + " is power of two. ");
		}
	}
}
