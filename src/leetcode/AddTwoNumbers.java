package leetcode;

/**
 * <p>Title: AddTwoNumbers.java</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 10, 2016
 * @version version 1.0
 */

/**
 * <p>Title: AddTwoNumbers</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 10, 2016
 * @time 10:28:28 AM
 */
public class AddTwoNumbers {

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
		AddTwoNumbers so = new AddTwoNumbers();
		ListNode l10 = null;
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l13 = new ListNode(2);
		ListNode l14 = new ListNode(1);

		ListNode l20 = null;
		ListNode l21 = new ListNode(9);
		ListNode l22 = new ListNode(9);
		ListNode l23 = new ListNode(9);

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
