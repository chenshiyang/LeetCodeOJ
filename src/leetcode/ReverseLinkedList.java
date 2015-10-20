/**
* <p>Title: ReverseLinkedList.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

import java.awt.DisplayMode;

/**
 * <p>Title: ReverseLinkedList</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 下午3:33:19
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(null == head || null == head.next) return head;
        ListNode pointer = head;
        ListNode pre = null;
        while(null != pointer){
        	//record next.
        	ListNode nex = pointer.next;
        	pointer.next = pre;
        	pre = pointer;
        	pointer = nex;
        }
        return pre;
    }
    
    public void display(ListNode node){
    	while(null != node){
    		System.out.print(node.val + "->");
    		node = node.next;
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		rl.display(n1);
		rl.display(rl.reverseList(n1));
		
	}
}
