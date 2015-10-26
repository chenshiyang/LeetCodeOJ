/**
* <p>Title: MinStack.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

import java.util.Stack;

/**
 * <p>Title: MinStack</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午8:06:33
 */
public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
    public void push(int x) {
        if(minStack.empty() || x <= minStack.peek()){
        	minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek())){
        	minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
