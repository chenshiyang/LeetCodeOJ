/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月15日
* @version jdk8.0
*/
package valid_anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月15日
 * @time 上午10:38:03
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
    	if(s == null && t == null)
    		return true;
    	
        if(s == null || t == null || s.length() != t.length())
        	return false;
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        //traverse s.
        for(int i = 0; i < s.length(); i ++){
        	Integer val = table.get(s.charAt(i));
        	if(val == null)
        		table.put(s.charAt(i), 1);
        	else
        		table.put(s.charAt(i), val + 1);
        }
        //traverse t.
        for(int i = 0; i < t.length(); i ++){
        	Integer val = table.get(t.charAt(i));
        	if(val == null)
        		return false;
        	else if(val > 1)
        		table.put(t.charAt(i), val - 1);
        	else//val == 1
        		table.remove(t.charAt(i));
        }
        return table.size() == 0;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		String[] s1 = {
				"chenshiyang",
				"shiyang",
				"chenshiyang",
				"csychenshiyangsyc"
		};
		String[] s2 = {
				"shiyangchen",
				"chen",
				"chanshiyang",
				"csychenshiyangscy"
		};
		boolean[] ans = {
				true, false, false, true
		};
		for(int i = 0; i < s1.length; i ++){
			System.out.println(so.isAnagram(s1[i], s2[i]) == ans[i]);
		}
	}
}
