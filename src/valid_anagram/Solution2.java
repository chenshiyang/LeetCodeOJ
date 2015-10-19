/**
* <p>Title: Solution2.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月15日
* @version jdk8.0
*/
package valid_anagram;

/**
 * <p>Title: Solution2</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月15日
 * @time 上午11:04:22
 */
public class Solution2 {
	public boolean isAnagram(String s, String t) {
		if(s == null && t == null)
			return true;
		if(s == null || t == null || s.length() != t.length())
			return false;
		int[] alphabets = new int[26];//bacause the string only contains lowercase letters.
		for(int i = 0; i < s.length(); i ++){
			alphabets[s.charAt(i) - 'a'] ++;
		}
		for(int i = 0; i < t.length(); i ++){
			if(-- alphabets[t.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}
	
	   public static void main(String[] args) {
			Solution2 so = new Solution2();
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
