/**
* <p>Title: Solution3.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 25, 2015
* @version jdk8.0
*/
package longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: Solution3</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 25, 2015
 * @time 9:31:17 AM
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int currentLength = 0, maxLength = 0;
        int lastSmaller = 0;//历史上重复子串的左端索引的最大值。
        Map<Character,Integer> table = new HashMap<Character, Integer>();
        int[] locations = new int[256];
        for(int i = 0; i < locations.length; i ++){
        	locations[i] = -1;
        }
        
        for(int i = 0; i < s.length(); i ++){
        	if(locations[s.charAt(i)] == -1){//如果当前子串中不包含字符 s[i]
        		currentLength ++;//当前子串长度加1
        		locations[s.charAt(i)] = i;//将s[i]加入表中,索引为值
        	}
        	else{//s[i]在当前子串中已经出现过了
        		int lastIndex = locations[s.charAt(i)];
        		//当前子串已到尽头，若其长度大于历史长度，则更新maxLength
        		maxLength = Math.max(maxLength, currentLength);
        		//重新开始新的子串, 子串由lastSmaller 的下一个字符开始
        		lastSmaller = Math.max(lastSmaller, lastIndex);
        		currentLength = i - lastSmaller;
        		//更新s[i]在table中的索引值
        		locations[s.charAt(i)] = i;
        		
        	}
        }
        maxLength = Math.max(maxLength, currentLength);
    	return maxLength;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		String[] s1 ={ "",
		 "a",
		"ab",
		 "aba",
		 "aa",
		"lksdj;a;hj;lkdfsj;erugahflhlkjdfha",
		"abcdefghijklmnopqrstuvwxyzal;kjgaerghkjdsghlkdsgjh",
		"abcdaefghi",
		";jglkjdg;ai jt;iajmndkfj ghqqqqwertyuiopasdfghjkllllll"};
		long current = System.currentTimeMillis();
		for(int i = 0 ; i < 9 ; i ++){
			System.out.println(so.lengthOfLongestSubstring(s1[i]));
		}
		System.out.println("time used : " + (System.currentTimeMillis() - current));
	}
}
