/**
* <p>Title: MergeTwoSortedLists.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: MergeTwoSortedLists</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 上午11:15:45
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(null == l1) return l2;
    	if(null == l2) return l1;
        ListNode head = new ListNode(0);//forge head
        
        ListNode body = head;
        
        while(null != l1 || null != l2){
        	if(null == l2 || (null != l1 && l1.val <= l2.val)){
        		body.next = l1;
        		body = l1;
        		l1 = l1.next;
        	}
        	else if(null == l1 || l2.val <= l1.val){
        		body.next = l2;
        		body = l2;
        		l2 = l2.next;
        	}
        }
        
        return head.next;
    }
    
    public void display(ListNode node){
    	while(null != node){
    		System.out.print(node.val + "->");
    		node = node.next;
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		MergeTwoSortedLists so = new MergeTwoSortedLists();
		
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(6);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(5);
		ListNode n8 = new ListNode(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
//		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		so.display(n1);
		so.display(n5);
		so.display(so.mergeTwoLists(n1, n5));
	}
}
