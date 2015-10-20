/**
* <p>Title: ImplementStackUsingQueues.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title: ImplementStackUsingQueues</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 上午9:29:00
 */
public class ImplementStackUsingQueues {
	private Queue<Integer> queue = new LinkedList<Integer>();
//	Queue<Integer> secondq = new LinkedList<Integer>();
	private int size = 0;
	
    // Push element x onto stack. O(1)
    public void push(int x) {
        queue.offer(x);
        size ++;
    }

    // Removes the element on top of the stack. O(n)
    public void pop() {
        for(int i = 0; i < size - 1; i ++){
        	int head = queue.poll();
        	queue.offer(head);
        }
        //pop target element.
        queue.poll();
        size --;
    }

    // Get the top element. O(n)
    public int top() {
        for(int i = 0; i < size - 1; i ++){
        	int head = queue.poll();
        	queue.offer(head);
        }
        //get target element.
        int target = queue.peek();
        //then recover the queue
        queue.offer(queue.poll());
        return target;
    }

    // Return whether the stack is empty. O(1)
    public boolean empty() {
        return size == 0;
    }
    
    public static void main(String[] args) {
		ImplementStackUsingQueues so = new ImplementStackUsingQueues();
		System.out.println("stack empty ? " + so.empty());
		System.out.println("push 1");
		so.push(1);
		System.out.println("stack empty ? " + so.empty());
		System.out.println("push 2");
		so.push(2);
		System.out.println("peek " + so.top());
		System.out.println("pop");
		so.pop();
		System.out.println("peek " + so.top());
		System.out.println("pop");
		so.pop();
		System.out.println("stack empty " + so.empty());
		
	}
}
