/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月14日
* @version jdk8.0
*/
package word_pattern;

import java.util.HashMap;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月14日
 * @time 下午5:20:52
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] sarry = str.split(" ");
        if(sarry.length != pattern.length())
        	return false;
        
        HashMap<Character, Integer> patTable = new HashMap<Character, Integer>();
        HashMap<String, Integer> strTable = new HashMap<String, Integer>();
        
        for(int i = 0; i < sarry.length; i ++){
        	Integer c = patTable.get(pattern.charAt(i));
        	Integer s = strTable.get(sarry[i]);
        	if(c != s)
        		return false;
        	//else, c == s
        	c = c == null? 1 : c + 1;
        	s = c;
        	patTable.put(pattern.charAt(i), c);
        	strTable.put(sarry[i], s);
        }
        return true;
    }
    //test.
    public static void main(String[] args) {
		Solution so = new Solution();
		String pa1 = "abba";
		String s1 = "dog cat cat dog";
		String pa2 = "abc";
		String s2 = "dog cat pig";
		String pa3 = "abcd";
		String s3 = "dog cat pig monkey hen";
		System.out.println(so.wordPattern(pa1, s1));
		System.out.println(so.wordPattern(pa2, s2));
		System.out.println(so.wordPattern(pa1, s2));
		System.out.println(so.wordPattern(pa2, s1));
		System.out.println(so.wordPattern(pa3, s3));
	}
}
