/**
* <p>Title: ImplementQueueUsingStacks.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月16日
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * <p>Title: ImplementQueueUsingStacks</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月16日
 * @time 下午9:47:50
 */
public class ImplementQueueUsingStacks {
	private Stack<Integer> rear = new Stack<Integer>();
	private Stack<Integer> head = new Stack<Integer>();
	private int size;
	
    // Push element x to the back of queue.
    public void push(int x) {
        rear.push(x);
        size ++;
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(size <= 0) return;
        if(! head.isEmpty()){
        	head.pop();
        	size --;
        }
        else{
        	while(rear.size() > 0){
        		head.push(rear.pop());
        	}
        	head.pop();
        	size --;
        }
    }

    // Get the front element.
    public int peek() {
        if(! head.isEmpty()){
        	return head.peek();
        }
        else{
/*        	Iterator<Integer> iterator = rear.iterator();
        	while(iterator.hasNext()){
        		head.push(iterator.next());
        	}*/
        	while(rear.size() > 0){
        		head.push(rear.pop());
        	}
        	return head.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return rear.isEmpty() && head.isEmpty();
    }
    
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	while(head.size() > 0){
    		int element = head.pop();
    		sb.append(element + "->");
    		list.add(element);
    	}
    	while(rear.size() > 0){
    		head.add(rear.pop());
    	}
    	while(head.size() > 0){
    		int element = head.pop();
    		sb.append(element + "->");
    		list.add(element);
    	}
    	for(int i = 0; i < list.size(); i ++){
    		head.push(list.get(list.size() - 1 - i));
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		ImplementQueueUsingStacks so = new ImplementQueueUsingStacks();
		for(int i = 1; i < 3; i ++){
			System.out.println("push " + i);
			so.push(i);
		}
//		System.out.println(so);
		System.out.println("peek " + so.peek());
		System.out.println("pop");
		so.pop();
		System.out.println("peek " + so.peek());
		System.out.println(so);
		System.out.println("push 11");
		so.push(11);
		System.out.println(so);
		System.out.println("pop");
		so.pop();
		System.out.println("is it empty?");
		System.out.println(so.empty());
		System.out.println("pop until empty");
		while(!so.empty()){
			so.pop();
		}
		System.out.println("Is it empty?");
		System.out.println(so.empty());
	}
}
