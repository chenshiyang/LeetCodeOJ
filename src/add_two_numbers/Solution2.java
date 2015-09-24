/**
 * <p>Title: Solution2.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: CSY</p>
 * @author chenshiyang
 * @date Sep 24, 2015
 * @version jdk8.0
 */
package add_two_numbers;

import add_two_numbers.Solution.ListNode;

/**
 * <p>
 * Title: Solution2
 * </p>
 * <p>
 * Description:  Add two numbers 的解法二
 * 与解法一相比：代码更清晰、简短，速度也快了不少。虽然时间复杂度都是O(max(m,n))。
 * </p>
 * 
 * @author chenshiyang
 * @date Sep 24, 2015
 * @time 3:12:51 PM
 * 
 */
public class Solution2 {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return this.val + "";
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return null;
		ListNode pre = new ListNode(0);//暂时引入一个头节点，不参与运算
		ListNode head = pre;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			pre.next = new ListNode(carry % 10);
			carry = carry / 10;
			pre = pre.next;
		}
		return head.next;
	}

	public static void main(String[] args) {
		Solution2 so = new Solution2();
		ListNode l10 = null;
		ListNode l11 = so.new ListNode(1);
		ListNode l12 = so.new ListNode(2);
		ListNode l13 = so.new ListNode(2);
		ListNode l14 = so.new ListNode(1);

		ListNode l20 = null;
		ListNode l21 = so.new ListNode(9);
		ListNode l22 = so.new ListNode(9);
		ListNode l23 = so.new ListNode(9);

		l11.next = l12;
		l12.next = l13;
		l21.next = l22;
		l22.next = l23;

		ListNode res = so.addTwoNumbers(l14, l21);
		if (res != null) {
			while (res != null) {
				System.out.println(res.toString());
				res = res.next;
			}
		} else
			System.out.println("null");
	}
}
