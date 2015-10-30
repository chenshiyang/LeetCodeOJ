/**
* <p>Title: RomanToInteger.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: RomanToInteger</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 下午5:17:05
 */
public class RomanToInteger {
	   public int romanToInt(String s) {
		   //build digit map.
		   Map<Character, Integer> digitMap = new HashMap<Character, Integer>();
		   digitMap.put('I', 1);
		   digitMap.put('V', 5);
		   digitMap.put('X', 10);
		   digitMap.put('L', 50);
		   digitMap.put('C', 100);
		   digitMap.put('D', 500);
		   digitMap.put('M', 1000);
		   //traverse from the right beginning.
		   //if current digit(say a) is not smaller than last digit, then plus a, else minus a.
		   int value = 0;
		   value += digitMap.get(s.charAt(s.length() - 1));
		   if(s.length() == 1)
			   return value;
		   for(int i = s.length() - 2; i >= 0; i --){
			   if(digitMap.get(s.charAt(i)) >= digitMap.get(s.charAt(i + 1))){
				   value += digitMap.get(s.charAt(i));
			   }
			   else{
				   value -= digitMap.get(s.charAt(i));
			   }
		   }
		   return value;
	   } 
	   
	   //solution 2 : use switch
	   public int romanToInt2(String s) {
	        int result = 0;
	        int prev = Integer.MAX_VALUE;
	        for(int i = 0; i < s.length(); i++){
	            int number = 0;
	            switch(s.charAt(i)){
	                case 'I' : number = 1; break;
	                case 'V' : number = 5; break;
	                case 'X' : number = 10; break;
	                case 'L' : number = 50; break;
	                case 'C' : number = 100; break;
	                case 'D' : number = 500; break;
	                case 'M' : number = 1000; break;
	            }
	            result += number;
	            if(prev < number)
	                result -= (2*prev);
	            prev = number;
	        }
	        return result;
	    }
	   
	   public static void main(String[] args) {
			RomanToInteger so = new RomanToInteger();
			String[] tests = {
					"MCMLIV",
					"MCMXC",
					"MMXIV",
					"MCMIV",
					"IV"
			};
			int[] ans = {
				1954,
				1990,
				2014,
				1904,
				4
			};
			for(int i = 0; i < tests.length; i ++){
				System.out.println(so.romanToInt2(tests[i]) == ans[i]);
			}
		}
}
