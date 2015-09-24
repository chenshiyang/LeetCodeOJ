/**
 * <p>Title: Solution.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: CSY</p>
 * @author chenshiyang
 * @date Sep 24, 2015
 * @version jdk8.0
 */
package add_two_numbers;

/**
 * <p>
 * Title: Solution
 * </p>
 * <p>
 * Description: Add two numbers 的解法一，时间复杂度为O(max(m, n))。但要考虑的情况很多，
 * 代码写起来也不简洁。
 * </p>
 * 
 * @author chenshiyang
 * @date Sep 24, 2015
 * @time 10:27:56 AM
 */
public class Solution {

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
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode header = l1;
		ListNode mark = l1;
		int carry = 0;
		while (l1 != null && l2 != null) {
			l1.val = l1.val + l2.val + carry;
			carry = 0;
			if (l1.val >= 10) {
				l1.val = l1.val - 10;
				carry = 1;
			}
			mark = l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 == null) {
			if (l2 == null) {
				if (carry != 0)
					mark.next = new ListNode(carry);
			} else if (l2 != null) {
				mark.next = l2;
				while (l2 != null) {
					l2.val = l2.val + carry;
					carry = 0;
					if (l2.val >= 10) {
						l2.val = l2.val - 10;
						carry = 1;
					}
					mark = l2;
					l2 = l2.next;
				}
				//check the carry bit
				if(carry == 1){
					mark.next = new ListNode(1);
				}
			}
		} else {
			while (l1 != null) {
				l1.val = l1.val + carry;
				carry = 0;
				if (l1.val >= 10) {
					l1.val = l1.val - 10;
					carry = 1;
				}
				mark = l1;
				l1 = l1.next;
			}
			//check the carry bit
			if(carry == 1){
				mark.next = new ListNode(1);
			}
		}
		return header;
	}

	public static void main(String[] args) {
		Solution so = new Solution();
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
