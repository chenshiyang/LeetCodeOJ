/**
* <p>Title: OddEvenLinkedList.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Jan 18, 2016
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: OddEvenLinkedList</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 18, 2016
 * @time 10:13:25 AM
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(null == head || null == head.next){
        	return head;
        }
        
        ListNode evenStart = head.next;//store the even start.
        ListNode odd = head;
        ListNode even = head.next;
        	
        while(null != odd.next && null != odd.next.next){
        		odd.next = odd.next.next;
        		odd = odd.next;
        		if(null != even.next){
        			even.next = even.next.next;
        			even = even.next;
        		}  	
        }
        if(null == odd.next){
        	odd.next = evenStart;
        }
        else{
        	even = even.next;
        	odd.next = evenStart;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
		OddEvenLinkedList so = new OddEvenLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
//		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
//		n6.next = n7;
		n7.next = null;
		
		ListNode head = so.oddEvenList(n1);
		
		while(null != head){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
