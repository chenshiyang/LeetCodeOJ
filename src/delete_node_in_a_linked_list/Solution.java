/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月15日
* @version jdk8.0
*/
package delete_node_in_a_linked_list;

import java.awt.DisplayMode;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月15日
 * @time 上午11:35:40
 */
public class Solution {
	// Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
    public void deleteNode(ListNode node) {
    	if(node != null && node.next != null){
    		node.val = node.next.val;
    		node.next = node.next.next;	
    	}
    }
    
    public void display(ListNode node){
    	ListNode temp = node;
    	while(temp != null){
    		System.out.println(temp.val + "->");
    		temp = temp.next;
    	}
    	System.out.println();
    	return;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		ListNode n1 = so.new ListNode(1);
		ListNode n2 = so.new ListNode(2);
		ListNode n3 = so.new ListNode(3);
		ListNode n4 = so.new ListNode(4);
		ListNode n5 = so.new ListNode(5);
		ListNode n6 = so.new ListNode(6);
		ListNode n7 = so.new ListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		
		so.display(n1);
		so.deleteNode(n1);
		so.display(n1);
	}
}
