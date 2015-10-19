/**
* <p>Title: PalindromeLinkedList.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月16日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: PalindromeLinkedList</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月16日
 * @time 下午4:30:48
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){//null or length equals 1.
        	return true;
        }
        
        //get the center of list.
        //each iteration, fast + 2, slow + 1, so when fast gets to the
        //end, slow is in the middle.
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        //reverse the second half list.
        ListNode secondHead = slow.next;
        slow.next = null;//break list into two sublist.
        ListNode p1 = secondHead;
        ListNode p2 = secondHead.next;
        while(p1 != null && p2 != null){
        	ListNode temp = p2.next;
        	p2.next = p1;
        	p1 = p2;
        	p2 = temp;
        }
        secondHead.next = null;
        
        secondHead = p2 == null ? p1 : p2;
        
        //compare to linked list.
        while(head != null && secondHead != null){
        	if(head.val != secondHead.val){
        		return false;
        	}
        	head = head.next;
        	secondHead = secondHead.next;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
		PalindromeLinkedList pll = new PalindromeLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(1);
		
		n1.next = n2;
//		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		System.out.println(pll.isPalindrome(n1));
	}
}
