/**
* <p>Title: RemoveLinkedListElements.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: RemoveLinkedListElements</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 下午5:08:49
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
    	//get head.
    	while(null != head && head.val == val)
    		head = head.next;
    	if(null == head) return head;
    	
        ListNode pointer = head;
        ListNode prev = null;
        
        while(pointer != null){
        	if(pointer.val == val){
        		if(null != prev)
        			prev.next = pointer.next;
        		pointer = pointer.next;
        	}
        	else{
        		prev = pointer;
        		pointer = pointer.next;
        	}
        }
        
        return head;
    }
    
    public void display(ListNode node){
    	while(null != node){
    		System.out.print(node.val + "->");
    		node = node.next;
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		RemoveLinkedListElements so = new RemoveLinkedListElements();
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
		so.display(n1);
		so.removeElements(n1, 1);
		System.out.println("=====After remove=======");
		so.display(so.removeElements(n1, 1));
		System.out.println("=====After remove=======");
		so.display(so.removeElements(n1, 7));
		
	}
}
