/**
* <p>Title: IsomorphicStrings.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: IsomorphicStrings</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 下午3:54:02
 */
public class IsomorphicStrings {
    /**
    * <p>Description: Time O(n), Space O(n)</p>
    * @param s
    * @param t
    * @return
    */
/*    public boolean isIsomorphic(String s, String t) {
    	if(s.length() != t.length()) return false;
    	
    	Map<Character, Integer> sable = new HashMap<Character, Integer>();
    	Map<Character, Integer> table = new HashMap<Character, Integer>();
    	int[] sarry = new int[s.length()];
    	int[] tarry = new int[t.length()];
    	int scount = 0, tcount = 0;
    	
    	for(int i = 0; i < s.length(); i ++){
    		Integer val = sable.get(s.charAt(i));
    		if(null != val){
    			sarry[i] = val;
    		}
    		else{
    			sarry[i] = scount;
    			sable.put(s.charAt(i), scount);
       			scount ++;
    		}
    		
    		val = table.get(t.charAt(i));
    		if(null != val){
    			tarry[i] = val;
    		}
    		else{
    			tarry[i] = tcount;
    			table.put(t.charAt(i), tcount);
       			tcount ++;
    		}
    		
    		if(sarry[i] != tarry[i])
    			return false;
    	}
    	return true;
    }*/
    
    public boolean isIsomorphic(String s, String t) {
    	if(s.length() != t.length()) return false;
    	
    	Map<Character, Integer> sable = new HashMap<Character, Integer>();
    	Map<Character, Integer> table = new HashMap<Character, Integer>();

    	int count = 0;
    	
    	for(int i = 0; i < s.length(); i ++){
    		Integer si = null;
    		Integer ti = null;
    		si = sable.get(s.charAt(i));
    		ti = table.get(t.charAt(i));
    		if(si != ti)
    			return false;
    		
    		if(si == null){
    			sable.put(s.charAt(i), count);
    			table.put(t.charAt(i), count);
    			count ++;
    		}
    	}
    	return true;
    }
	
    public static void main(String[] args) {
		IsomorphicStrings is = new IsomorphicStrings();
		String s1 = "egg";
		String t1 = "odd";
		String s2 = "foo";
		String t2 = "bar";
		String s3 = "paper";
		String t3 = "title";
		
		System.out.println(is.isIsomorphic(s1, t1));
		System.out.println(is.isIsomorphic(s2, t2));
		System.out.println(is.isIsomorphic(s3, t3));
	}
}
