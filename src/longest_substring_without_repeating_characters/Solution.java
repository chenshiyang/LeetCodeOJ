/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 24, 2015
* @version jdk8.0
*/
package longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
	 * 算法:
	 * 对输入的字符串，转化成字符数组
	 * 1.读入一个字符
	 * 2.若该字符没有出现在hashmap中，则该字符是新的：
	 * 	将当前长度加1，并将该字符值及其索引存入hashmap中
	 *   若该字符出现在hashmap中，说明该字符在前面出现过，需要做：
	 *   	保存历史的最长长度；
	 *   	计算当前新的长度，计算方法如下：
	 *   	通常的想法是用当前读到的字符的索引减去该字符的上一次索引（即其在hashmap中的值），但
	 *   	这种想法存在问题。如字符串“lksdj;a;hj;l”，当我们第二次读到 j的时候，用j的当前索引9 -j在hashmap
	 *   	中的值4 ，得5，但这是错的，因为两个j中间存在着一个“;”的重复子串。这个“;”是哪来的呢？我们要注意到
	 *   	这个重复的“;”其实是上一次的 读入的字符(第二个";")存在在hashmap中(map中的是第一个";")这种情况下引入的，因此我们可以在每次读到
	 *   	字符，若该字符存在在hashmap中，（就是第二种if的情况），就记下它的hashmap的值（即它的较小的那个
	 *   	索引）。这里我们用一个lastSmaller 来记录(last duplicate char's smaller index)，lastSmaller 就是上一次较小的意思，
	 *   	用来记录上一次出现重复的那个字符的较小的索引。以这个字符串为例，“;”的lastSmaller
	 *   	为5，注意了！因为5>4，4为j的hashmap值，故我们的当前子串长度不应为9-4，而应为9-5，才能保证j和；都
	 *   	不会重复。若是；的lastSmaller<4呢？ 我们注意到这时候；对j的子串计算没有影响，即当前子串长度为9-4=5.。但
	 *   	是，因为lastSmaller<4，所以我们要更新lastSmaller,使得保证lastSmaller是**历史中**重复子串其较小索引中的**最大值**。
	 *   	计算完当前新的子串长度后，我们还需要更新hashmap，将当前字符的旧索引换成其新索引。
	 * 3.检查历史长度和当前长度，它们中的最大值即为结果。
	 * 
	 * 这个算法相比于solution2的优点是：不用每遇到一个字符，就更新maxLength。但是要小心**嵌套重复**的陷阱。
	 * 但是速度比solution2慢，将hashmap换成array后，速度就比solution2快了，见solution3。 使用hashmap会影响速度，这个
	 * 很奇怪。
 * @author chenshiyang
 * @date Sep 24, 2015
 * @time 10:53:46 PM
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int currentLength = 0, maxLength = 0;
        int lastSmaller = 0;//历史上重复子串的左端索引的最大值。
        Map<Character,Integer> table = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i ++){
        	if(table.get(s.charAt(i)) == null){//如果当前子串中不包含字符 s[i]
        		currentLength ++;//当前子串长度加1
        		table.put(s.charAt(i), i);//将s[i]加入表中，字符为键，索引为值
        	}
        	else{//s[i]在当前子串中已经出现过了
        		int lastIndex = table.get(s.charAt(i));
        		//当前子串已到尽头，若其长度大于历史长度，则更新maxLength
        		maxLength = Math.max(maxLength, currentLength);
        		//重新开始新的子串, 子串由lastSmaller 的下一个字符开始
        		lastSmaller = Math.max(lastSmaller, lastIndex);
        		currentLength = i - lastSmaller;
        		//更新s[i]在table中的索引值
        		table.put(s.charAt(i), i);
        		
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
