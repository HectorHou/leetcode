//92. Reverse Linked List II   Add to List QuestionEditorial Solution  My Submissions
//Total Accepted: 95711
//Total Submissions: 320213
//Difficulty: Medium
//Contributors: Admin
//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
//
//Subscribe to see which companies asked this question
public class ReverseLinkedListII {
	/*
	 * Solution:
	 * 1.Use a new node to be the head
	 * 2.Find the position of m and n.
	 * 3.Insert the node to the position of m from m to n.
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n)
			return head;

		ListNode h = new ListNode(0);
		h.next = head;
		ListNode lm = h, ln = h, l = h;

		for (int i = 0; i < m - 1; i++)
			l = l.next;
		lm = l.next;
		ln = lm;
		for (int i = 0; i < n - m; i++)
			ln = ln.next;

		l.next = ln.next;
		ln.next = null;

		while (lm != null) {
			ln = lm.next;
			lm.next = l.next;
			l.next = lm;
			lm = ln;
		}

		return h.next;
	}

	public static void main(String[] args) {
		System.out.println(new ReverseLinkedListII().reverseBetween(ListNode.getOne(), 1, 2));
	}

}
