/**
* <p>Title: LengthOfLastWord.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月28日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: LengthOfLastWord</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月28日
 * @time 下午4:14:28
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
    	if(null == s) return 0;
        int l = s.length(), r = s.length();
        for(int i = s.length() - 1; i >= 0; i --){
        	if(Character.isSpaceChar(s.charAt(i)) && l < s.length() && Character.isLetter(s.charAt(l)))
        		break;
        	if(Character.isSpaceChar(s.charAt(i)))
        		r = i;
        	if(Character.isLetter(s.charAt(i))){
        		l = i;
        	}
        }
        return r - l > 0 ? r - l : 0;
    }
    
    public static void main(String[] args) {
		LengthOfLastWord so = new LengthOfLastWord();
		String s1 = "     ";
		String s2 = null;
		String s3 = " sd";
		String s4 = "    kj ab  cd csy ";
		String s5 = "";
		System.out.println(so.lengthOfLastWord(s1) == 0);
		System.out.println(so.lengthOfLastWord(s2) == 0);
		System.out.println(so.lengthOfLastWord(s3) == 2);
		System.out.println(so.lengthOfLastWord(s4) == 3);
		System.out.println(so.lengthOfLastWord(s5) == 0);
	}
}
