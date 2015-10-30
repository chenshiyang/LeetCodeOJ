/**
* <p>Title: PlusOne.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月28日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: PlusOne</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月28日
 * @time 下午4:00:23
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int carry = 1;
    	for(int i = digits.length - 1; i >= 0; i --){
    		digits[i] += carry;
    		if(digits[i] < 10)
    			break;
    		else{
    			digits[i] = 0;
    			carry = 1;
    		}
    	}
    	if(0 == digits[0]){// has a carry
    		int[] result = new int[1 + digits.length];
    		for(int i = 0; i < digits.length; i ++){
    			result[i + 1] = digits[i];
    		}
    		result[0] = 1;
    		return result;
    	}
    	else{
    		return digits;
    	}
    }
    
    public static void main(String[] args) {
		PlusOne so = new PlusOne();
		
		int[] t1 = {9,0,9};
		int[] res = so.plusOne(t1);
		for(int i = 0 ; i < res.length ; i ++)
			System.out.print(res[i]);
	}
}
