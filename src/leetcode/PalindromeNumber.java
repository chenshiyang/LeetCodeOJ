/**
* <p>Title: PalindromeNumber.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: PalindromeNumber</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 下午5:29:23
 */
public class PalindromeNumber {
    /**
     * 
     * 思路： 反向记下右半边，并和左半边比较。 因为只考虑一半，所以绝对不会溢出
     * 
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 0 ||(x % 10 ==0 && x != 0)){
        	return false;
        }      
        int i = 0 ;
        while( i < x){
        	i = i * 10 + x % 10;
        	x /=10;//精髓
        }
        if(x == i || i / 10 == x){// i/ 10 是考虑到可能有奇数位
        	return true;
        }
        return false;
    }
}
