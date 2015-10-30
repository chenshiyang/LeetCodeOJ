/**
* <p>Title: CountAndSay.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月28日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: CountAndSay</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月28日
 * @time 下午6:57:28
 */
public class CountAndSay {
    public String countAndSay(int n) {
    	if(n < 1) return "";
    	String s = "1";
        for(int i = 1; i < n; i ++){
        	s = translate(s);
        }
        return s;
    }
    
    private String translate(String s){
    	StringBuilder sb = new StringBuilder();
    	char digit = s.charAt(0);
    	int count = 1;
    	for(int i = 1; i < s.length(); i ++){
    		if(s.charAt(i) != s.charAt(i - 1)){
    			//add
    			sb.append(count);
    			sb.append(digit);
    			//reset
    			digit = s.charAt(i);
    			count = 1;
    		} else{
    			count ++;
    		}
    	}
    	sb.append(count);
    	sb.append(digit);
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		CountAndSay so = new CountAndSay();
		for(int i = 0; i < 14; i ++){
			System.out.println(i + " : " + so.countAndSay(i));
		}
	}
}
