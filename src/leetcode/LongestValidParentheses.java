/**
* <p>Title: LongestValidParentheses.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 1, 2015
* @version jdk8.0
*/
package leetcode;

import java.util.Stack;

/**
 * <p>Title: LongestValidParentheses</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 1, 2015
 * @time 12:57:29 PM
 */
public class LongestValidParentheses {
	
    public int longestValidParentheses(String s) {
    	//stack to store the left parenthesis '(' 's index.
        Stack<Integer> stack = new Stack<Integer>();
        //max: the historical max length.
        //left: the left of current head.
        int max = 0, left = 0;
        
        for(int i = 0; i < s.length(); i ++){
        	char c = s.charAt(i);
        	if('(' == c){
        		stack.push(i);
        	}
        	else{//')' == c
        		if(stack.isEmpty()){// this ')' will never be paired. so we need to get a new start.
        			left = i + 1;
        		}
        		else{//there are left parentheses in the stack.
        			stack.pop();
        			if(stack.isEmpty()){
        				max = Math.max(max, i - left + 1);
        			}
        			else{// there are remaining '(' waiting to be pair.
        				max = Math.max(max, i - stack.peek());
        			}
        		}
        	}
        }
        return max;
    }
    
    /**
     * Solution 2:Let '(' equals to 1 and ')' equals to -1,if s.substr(i,j-i+1) 
     * is a valid parentheses,then the sum of this substring should be 0.
     * 
    * <p>Description: 对不匹配的括号只有两种情况：
    * 在一个连续的括号串中，要么左边左括号多了，要么右边右括号多了。
    * 从左往右遍历时，无法处理左括号多了的这种情况： ()(().
    * 从右往左遍历时，则无法处理右括号多了的这种情况： (()))
    * 因此要从左右分别都扫描一次。</p>
    * @param s
    * @return
    */
    public int longestValidParentheses2(String s) {
    	if(s.length() < 2) return 0;
    	
    	int left = 0, right = s.length() - 1;
/*    	while(left < s.length()){
    		if(s.charAt(left) == ')'){
    			left ++;
    		}
    		else{
    			break;
    		}
    	}*/
    	left = s.indexOf('(');
    	right = s.lastIndexOf(')');
/*    	while(right >= 0){
    		if(s.charAt(right) == '('){
    			right --;
    		}
    		else{
    			break;
    		}
    	}*/
/*    	if(left == s.length() || right < 0 || left > right)
    		return 0;*/
    	if(-1 == left || -1 == right || left > right)
    		return 0;
    	s = s.substring(left, right + 1);
    	//from left to right.
    	int pos = 0, sum = 0, maxLen = 0;
    	for(int i = 0; i < s.length(); i ++){
    		sum += s.charAt(i) == '('? 1 : -1;// ( : 1, ) : -1.
    		if(sum < 0){
    			pos = i + 1;
    			sum = 0;
    		}
    		else if(0 == sum){
    			maxLen = Math.max(maxLen, i - pos + 1);
    		}
    	}
    	//from right to left.
    	pos = s.length() - 1;
    	sum = 0;
    	int maxLen1 = 0;
    	for(int i = s.length() - 1; i >= 0; i --){
    		sum += s.charAt(i) == '('? 1 : -1;
    		if(sum > 0){
    			pos = i - 1;
    			sum = 0;
    		}
    		else if(0 == sum){
    			maxLen1 = Math.max(maxLen1, pos - i + 1);
    		}
    	}
    	
    	return Math.max(maxLen, maxLen1);
    }
    
    /**
     * Solution 3
     * DP, Use a dp table to record whether parenthesis is get paired or not.
     * 
    * <p>Description: </p>
    * @param s
    * @return
    */
    public int longestValidParentheses3(String s) {
    	if(null == s || s.length() < 2)
    		return 0;
    	
    	int left = s.indexOf('(');
    	int right = s.lastIndexOf(')');
    	if(-1 == left || -1 == right || left > right)
    		return 0;
//    	s = s.substring(left, right + 1);//加上这行更慢，奇怪！
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean[] dptable = new boolean[s.length()];// true if can be paired.
    	
    	for(int i = 0; i < s.length(); i ++){
    		if('(' == s.charAt(i)){
    			stack.push(i);
    		}
    		else{
    			if(!stack.isEmpty()){
    				dptable[i] = true;
    				dptable[stack.pop()] = true;
    			}
    		}
    	}
    	
    	int maxLen = 0, len = 0;
    	for(int i = 0; i < dptable.length; i ++){
    		if(dptable[i]){
    			len ++;
    			maxLen = Math.max(maxLen, len);
    		}
    		else{
    			len = 0;
    		}
    	}
    	return maxLen;
    }
    
	/**
	 * <p>Description: </p>
	 * @param args
	 */
	public static void main(String[] args) {
		LongestValidParentheses so = new LongestValidParentheses();
		
		String test1 = "(()";
		String test2 = ")()())";
		String test3 = "(()(())))(()()()()";
		System.out.println(so.longestValidParentheses(test1));
		System.out.println(so.longestValidParentheses(test2));
		System.out.println(so.longestValidParentheses(test3));
		
		System.out.println(so.longestValidParentheses2(test1));
		System.out.println(so.longestValidParentheses2(test2));
		System.out.println(so.longestValidParentheses2(test3));
		System.out.println(so.longestValidParentheses3(test1));
		System.out.println(so.longestValidParentheses3(test2));
		System.out.println(so.longestValidParentheses3(test3));

	}

}
