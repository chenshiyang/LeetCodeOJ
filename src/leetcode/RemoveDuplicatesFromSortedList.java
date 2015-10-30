/**
* <p>Title: RemoveDuplicatesFromSortedList.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月28日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: RemoveDuplicatesFromSortedList</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月28日
 * @time 下午3:14:08
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head || null == head.next) return head;
        ListNode current = head;
        while(null != current){
        	while(null != current.next && current.val != current.next.val){
        		current = current.next;
        	}
        	if(null == current.next) break;
        	current.next = current.next.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
		RemoveDuplicatesFromSortedList so = new RemoveDuplicatesFromSortedList();
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(6);
		ListNode n8 = new ListNode(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		System.out.println("==== test1 ==== ");
		ListNode.display(n1);
		System.out.println("==== After remove ====");
		ListNode.display(so.deleteDuplicates(n1));
		
		System.out.println("==== test2 ==== ");
		ListNode.display(null);
		System.out.println("==== After remove ====");
		ListNode.display(so.deleteDuplicates(null));
		
		System.out.println("==== test3 ==== ");
		ListNode.display(n8);
		System.out.println("==== After remove ====");
		ListNode.display(so.deleteDuplicates(n8));
		
	}
}
