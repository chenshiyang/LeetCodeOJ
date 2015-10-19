/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 29, 2015
* @version jdk8.0
*/
package longest_palindromic_substring;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 29, 2015
 * @time 4:43:25 PM
 */
public class Solution {
    public String longestPalindrome(String s) {
    	if(s == null || s.length() < 2)
    		return s;
        int len = s.length();
        String longest = "";
        int[][] isPalindromic = new int[len][len];
        //长度为1的串必定为回文。
        for(int i = 0; i < len; i ++){
        	isPalindromic[i][i] = 1;
        }
        //长度为2的串
        for(int i = 0; i < len - 1; i ++){
        	if(s.charAt(i) == s.charAt(i + 1))
        		isPalindromic[i][i + 1] = 1;
        	else
        		isPalindromic[i][i + 1] = -1;
        }
        //长度大于2的串
        for(int l = len; l >= 1; l --){//l表示长度
        	for(int begin = 0; begin + l - 1< len; begin ++){
        		if(isPalindrome(s, begin, begin + l - 1, isPalindromic)){
        			if(l > longest.length())
        				longest = s.substring(begin, begin + l);
        		}
        	}
        }
        return longest;
    }
    
    public boolean isPalindrome(String s, int begin, int end, int[][] isPalindromic){
    	if(isPalindromic[begin][end] == 1)
    		return true;
    	else if(isPalindromic[begin][end] == -1)
    		return false;
    	else{
    		boolean re = s.charAt(begin) == s.charAt(end) && isPalindrome(s, begin + 1, end - 1, isPalindromic);
    		isPalindromic[begin][end] = re? 1 : -1;
    		return re;
    	}
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		String[] tests = {
			"",
			"a",
			"abc",
			"aba",
			"abchdjkllkjdfds",
			"kajd;glkjad;g;dfkgj;dkgfjqwertyuioiuytrewqghfksdhfh",
			"fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"
		};
		System.out.println(so.longestPalindrome(null));
		for(int i = 0; i < tests.length; i ++){
			System.out.print(tests[i] + "   " + so.longestPalindrome(tests[i]));
			System.out.println();
		}
	}
}
