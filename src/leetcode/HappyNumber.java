/**
* <p>Title: HappyNumber.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: HappyNumber</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 下午7:16:15
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if(n < 1) return false;//should be positive.
        Set<Integer> valueSet = new HashSet<Integer>();
        while(! valueSet.contains(n) && n != 1){
        	valueSet.add(n);
        	n = happyValue(n);
        }
        return n == 1;
    }
    
    private int happyValue(int x){
    	int value = 0;
    	while( x > 0){
    		value += Math.pow(x % 10, 2);
    		x /= 10;
    	}
    	return value;
    }
    
    public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.happyValue(19));
		System.out.println(hn.happyValue(82));
		System.out.println(hn.happyValue(68));
		System.out.println(hn.happyValue(100));
		
		System.out.println(hn.isHappy(1)  == true);
		System.out.println(hn.isHappy(19) == true);
		System.out.println(hn.isHappy(2) == false);
		System.out.println(hn.isHappy(82) == true);
		System.out.println(hn.isHappy(81) == false);
	}
}
