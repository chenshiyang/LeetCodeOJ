/**
* <p>Title: ImplementStrStr.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ImplementStrStr</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 上午10:06:26
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        
    }
    
    
    // solution 2 : KMP
    public int strStr2(String haystack, String needle) {
        int n = needle.length(), m = haystack.length();
        int[] key = new int[n];
        for(int i = 1;i < n;i++) {
            int j = key[i-1];
            while(j != 0 && (needle.charAt(i) != needle.charAt(j))) {
                j = key[j-1];
            }
            key[i] = j + (needle.charAt(i) == needle.charAt(j)?1:0);
        }

        int i = 0, j = 0;
        while(i < n && j < m) {
            if(i > 0 && needle.charAt(i) != haystack.charAt(j)) i = key[i-1];
            else {
                i += (needle.charAt(i) == haystack.charAt(j)?1:0);
                j++;
            }
        }
        return (i == n?j-n:-1);
    }
    
    public static void main(String[] args) {
		ImplementStrStr so = new ImplementStrStr();
		String h1 = "I am chenshiyang";
		String n1 = "shiyang";
		String h2 = "shiyang";
		String n2 = "chenshiyang";
		
		System.out.println(so.strStr2(h1, n1));
		System.out.println(so.strStr2(h2, n2));
	}
}
