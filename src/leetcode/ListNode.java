/**
* <p>Title: ListNode.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��16��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ListNode</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��16��
 * @time ����4:31:13
 */
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
	
    public static void display(ListNode node){
    	while(null != node){
    		System.out.print(node.val + "->");
    		node = node.next;
    	}
    	System.out.println();
    }
    
    public String toString(){
    	return this.val + "";
    }
}
