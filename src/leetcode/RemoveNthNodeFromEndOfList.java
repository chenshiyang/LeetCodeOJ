/**
* <p>Title: RemoveNthNodeFromEndOfList.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: RemoveNthNodeFromEndOfList</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 下午3:16:43
 */
public class RemoveNthNodeFromEndOfList {
    /**
    * <p>Description: Using two pointers. The first pointer walk n steps alone,
    * then the second pointer start the walk, until the first pointer encounter with
    * null. </p>
    * @param head
    * @param n
    * @return
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
//    	if(null == head.next) return null;
        ListNode p1 = head, p2 = head;
        //p1 walk alone.
        for(int i = 0; i < n; i ++){
        	p1 = p1.next;
        }
        //p1 and p2 walk together.
        while(null != p1 && null != p1.next){//如果p1 == null 说明 n == list.size(),即是要移除最后一个
        	p1 = p1.next;
        	p2 = p2.next;
        }
        if(null == p1) return head.next;
        //remove.
        p2.next = p2.next.next;
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
		RemoveNthNodeFromEndOfList so = new RemoveNthNodeFromEndOfList();
		
		ListNode n1 = new ListNode(8);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(6);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		ListNode n9 = new ListNode(9);
		n9.next = null;
		
		so.display(n1);
		so.display(so.removeNthFromEnd(n1, 8));
		so.removeNthFromEnd(n1, 2);
		so.display(n1);
		so.removeNthFromEnd(n1, 2);
		so.display(n1);
		
		so.display(n9);
		so.display(so.removeNthFromEnd(n9, 1));
	}
}
