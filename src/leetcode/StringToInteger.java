/**
* <p>Title: StringToInteger.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: StringToInteger</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 下午8:36:54
 */
public class StringToInteger {
	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    public int myAtoi(String str) {
    	int i = 0, n = str.length();
    	while( i < n && Character.isWhitespace(str.charAt(i)))
    		i ++;
    	int sign = 1;
    	if(i < n && str.charAt(i) == '+'){
    		i ++;
    	} else if(i < n && str.charAt(i) == '-'){
    		sign = -1;
    		i ++;
    	}
    	int num = 0;
    	while(i < n && Character.isDigit(str.charAt(i))){
    		int digit = Character.getNumericValue(str.charAt(i));
    		if(num > maxDiv10 || (num == maxDiv10 && digit >= 8)){
    			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    		}
    		num = num * 10 + digit;
    		i ++;
    	}
    	return sign * num;
    }
    
    public static void main(String[] args) {
		StringToInteger so = new StringToInteger();
		String s1 = "12345348959384";
		String s2 = "+2325235";
		String s3 = "-352352523526626";
		
		System.out.println(so.myAtoi(s1));
		System.out.println(so.myAtoi(s2));
		System.out.println(so.myAtoi(s3));
	}
}
