/**
* <p>Title: Solution2.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 21, 2015
* @version jdk8.0
*/
package roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: Solution2</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 21, 2015
 * @time 8:51:45 AM
 * 这个算法竟然比solution慢，真是难以置信。
 */
public class Solution2 {
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
	   
	   public static void main(String[] args) {
			Solution2 so = new Solution2();
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
				System.out.println(so.romanToInt(tests[i]) == ans[i]);
			}
		}
}
