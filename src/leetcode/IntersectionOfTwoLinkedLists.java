/**
* <p>Title: IntersectionOfTwoLinkedLists.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;

/**
 * <p>Title: IntersectionOfTwoLinkedLists</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午7:15:57
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(null != nodeA){
        	lenA ++;
        	nodeA = nodeA.next;
        }
        while(null != nodeB){
        	lenB ++;
        	nodeB = nodeB.next;
        }
        
        if(lenA > lenB){
        	nodeA = headA;
        	nodeB = headB;
        }
        else{
        	nodeA = headB;
        	nodeB = headA;
        }
        
        int diff = lenA > lenB ? lenA - lenB : lenB - lenA;
        for(int i = 0; i < diff; i ++){
        	nodeA = nodeA.next;
        }
        
        //start to compare.
        while(nodeA != null && nodeB != null){
        	if(nodeA == nodeB){
        		return nodeA;
        	}
        	nodeA = nodeA.next;
        	nodeB = nodeB.next;
        }
        return null;
    }
}
