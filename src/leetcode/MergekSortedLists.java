/**
* <p>Title: MergekSortedLists.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Nov 30, 2015
* @version jdk8.0
*/
package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>Title: MergekSortedLists</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Nov 30, 2015
 * @time 3:31:04 PM
 */
public class MergekSortedLists {
    /**
    * <p>Description: ����merge sort�е�merge ˼·����֮ͬ������mergeʱ�ǲ���һ����С�Ѳ�����СԪ��
    * �������СԪ�شӶ��ﵯ��ʱ������������list�ǿգ���������һ��Ԫ��ѹ����С�
    * ���Ӷȣ�ÿ��Ԫ�ض�Ҫ�����һ�Σ�����һ�Σ���2n�Σ�nΪԪ�ظ����� �ѵĴ�СΪk��ÿ�ν���ʱ�临�Ӷ�Ϊlogk.
    * ���ܵ�ʱ�临�Ӷ�Ϊ2nlogk</p>
    * @param lists
    * @return
    */
    public ListNode mergeKLists(ListNode[] lists) {
    	//margin condition
        if(null == lists || 0 == lists.length) return null;
        if(1 == lists.length) return lists[0];
        
        ListNode result = new ListNode(0);//an artificial head
        ListNode tail = result;
        // define a heap.
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}        	
		});
        for(int i = 0; i < lists.length; i ++){
        	if(null != lists[i]){
        		heap.offer(lists[i]);
        	}
        }

        while(!heap.isEmpty()){
        	tail.next = heap.poll();//add the minimum to list.
        	tail = tail.next;//move forward.
        	if(tail.next != null){//if this list is not empty, then push the next element into heap.
        		heap.offer(tail.next);
        	}
        }
        return result.next;
    }
    
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(7);
		ListNode n4 = new ListNode(8);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(4);
		ListNode n8 = new ListNode(5);
		ListNode n9 = new ListNode(3);
		ListNode n10 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		n9.next = n10;
		n10.next = null;
		
		ListNode[] lists = new ListNode[3];
		lists[0] = n1;
		lists[1] = n5;
		lists[2] = n9;
		
		MergekSortedLists so = new MergekSortedLists();
		ListNode res = so.mergeKLists(lists);
		
		while(res != null){
			System.out.print(res.val + "=>");
			res = res.next;
		}
		System.out.println();
		System.out.println("==============================");
	}
}
