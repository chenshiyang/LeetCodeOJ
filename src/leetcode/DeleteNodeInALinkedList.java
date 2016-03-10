/**
* <p>Title: DeleteNodeInALinkedList.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Mar 10, 2016
* @version version 1.0
*/
package leetcode;

/**
 * <p>Title: DeleteNodeInALinkedList</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 10, 2016
 * @time 10:34:13 AM
 */
public class DeleteNodeInALinkedList {
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
		DeleteNodeInALinkedList so = new DeleteNodeInALinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
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
