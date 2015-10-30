/**
* <p>Title: ValidParentheses.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

import java.util.Stack;

/**
 * <p>Title: ValidParentheses</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 下午2:49:59
 */
public class ValidParentheses {
    public boolean isValid(String s) {
    	if(null == s) return true;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i ++){
        	char c = s.charAt(i);
        	if('(' == c || '[' == c || '{' == c)
        		stack.push(c);
        	else{// c is ) or ] or }
        		if(! stack.isEmpty() && ((')' == c && '(' == stack.peek()) ||	// ()
        				(']' == c && '[' == stack.peek()) ||					//[]
        				('}' == c && '{' == stack.peek())))						//{}
        			stack.pop();
        		else
        			return false;
        	}       	
        }
        return stack.isEmpty();
    }
    
    // same solution, using switch expression.
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < s.length() ; i ++){
        	switch (s.charAt(i)){
        	case '(' : stack.push('(');break;
        	case ')' : if(stack.isEmpty()){return false;};if(stack.peek() == '('){stack.pop();}else return false; break;
        	case '[' : stack.push('[');break;
        	case ']' :  if(stack.isEmpty()){return false;};if(stack.peek() == '['){stack.pop();}else return false; break;
        	case '{' : stack.push('{');break;
        	case '}' :  if(stack.isEmpty()){return false;};if(stack.peek() == '{'){stack.pop();}else return false; break;
        	}
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
		ValidParentheses so = new ValidParentheses();
		
		String s1 = "";
		String s2 = "()";
		String s3 = "()[]{}";
		String s4 = "(()[])";
		String s5 = "()()(){[()]()}{[]}";
		String s6 = "()()(){[()]()}{[]}}";
		
		if(so.isValid(s1) == true)
			System.out.println("pass.");
		if(so.isValid(s2) == true)
			System.out.println("pass.");
		if(so.isValid(s3) == true)
			System.out.println("pass.");
		if(so.isValid(s4) == true)
			System.out.println("pass.");
		if(so.isValid(s5) == true)
			System.out.println("pass.");
		if(so.isValid(s6) == true)
			System.out.println("pass.");
	}
}
