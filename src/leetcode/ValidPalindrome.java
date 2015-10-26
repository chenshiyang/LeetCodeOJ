/**
* <p>Title: ValidPalindrome.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��20��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ValidPalindrome</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��20��
 * @time ����8:13:41
 */
public class ValidPalindrome {
	
	//Solution 1 : 
    public boolean isPalindrome(String s) {
    	if(null == s || s.length() <= 1) return true;
        int left = 0, right = s.length() - 1;
        while(left < right){
        	while(left < right && ! Character.isAlphabetic(s.charAt(left)) && ! Character.isDigit(s.charAt(left)))
        		left ++;
        	while(left < right && ! Character.isAlphabetic(s.charAt(right)) && ! Character.isDigit(s.charAt(right)))
        		right --;
        	
        	if(left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
        		return false;
        	
        	left ++;
        	right --;
        }
        return true;
    }
    
    //Solution 2 :
    public boolean isPalindrome2(String s) {
        //if string is empty ,then return true
    	if(s.equals("")|| s.length() ==1){
        	return true;
        }
    	// ȥ�����еķǴ��ַ�^��a-zA-Z0-9��
        s = s.replaceAll("[^\\w]+", "");
        s = s.toLowerCase();
        System.out.println(s);
        //�Ƚ�s��s��reverse�Ƿ���ͬ
    	System.out.println(new StringBuilder(s).reverse().toString());
    	boolean result = s.equals(new StringBuilder(s).reverse().toString());
    	return result;
    }
    
    public static void main(String[] args) {
		ValidPalindrome so = new ValidPalindrome();
    	String s = "abc. /. de....f e   d /.c\\b==a";
    	String s1 = "";
    	System.out.println(so.isPalindrome(s1));
    	System.out.println(so.isPalindrome(s));
	}
}
