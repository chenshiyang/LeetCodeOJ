/**
* <p>Title: LongestCommonPrefix.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: LongestCommonPrefix</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 下午4:31:04
 */
public class LongestCommonPrefix {
	
	// solution 1 : 3ms
	
    public String longestCommonPrefix(String[] strs) {
    	if(null == strs) return null;
    	if(0 == strs.length) return "";
    	String s = strs[0];
        for(int i = 1; i < strs.length; i ++){
        	s = commonPrefix(s, strs[i]);
        }
        return s;
    }
    
    private String commonPrefix(String s1, String s2){
    	int len = Math.min(s1.length(), s2.length());
    	int count = 0;
    	for(int i = 0; i < len && s1.charAt(i) == s2.charAt(i); i ++){
    		count ++;
    	}
    	return count == 0 ? "" : s1.substring(0, count);
    }
    
    // solution 2 : 2ms
    
    public String longestCommonPrefix2(String[] strs) {
    	if(null == strs) return null;
    	if(0 == strs.length) return "";
    	
    	//get shortest length
    	int shortest = Integer.MAX_VALUE;
    	for(int i = 0; i < strs.length; i ++){
    		if(strs[i].length() < shortest)
    			shortest = strs[i].length();
    	}

    	//
    	StringBuilder sb = new StringBuilder();
    	String s= strs[0];
    	for(int i = 0; i < shortest; i ++){
    		if(isPrefix(strs, s.charAt(i), i)){
    			sb.append(s.charAt(i));
    		} else{
    			break;
    		}
    	}
    	return sb.toString();
    }
    
    private boolean isPrefix(String[] strs, char c, int index){
    	for(int i = 0; i < strs.length; i ++){
    		if(c != strs[i].charAt(index))
    			return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		LongestCommonPrefix so = new LongestCommonPrefix();
		String[] tests = {
				"chenshiyang",
				"chenshifeng",
				"chenchen",
				"chenxiuqi",
				"che"
		};
		
		System.out.println(so.longestCommonPrefix2(tests));
	}
}
