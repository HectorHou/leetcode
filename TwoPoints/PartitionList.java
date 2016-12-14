// 86. Partition List   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 84349
// Total Submissions: 268993
// Difficulty: Medium
// Contributors: Admin
// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
// You should preserve the original relative order of the nodes in each of the two partitions.
//
// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

public class PartitionList {
	/*
	 * Solution:Use two new list: one to store the node smaller than x and the
	 * other one store the node greater than x or equal to x. Merge the two
	 * list.
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
		ListNode curr1 = dummy1, curr2 = dummy2;
		while (head != null) {
			if (head.val < x) {
				curr1.next = head;
				curr1 = head;
			} else {
				curr2.next = head;
				curr2 = head;
			}
			head = head.next;
		}
		curr2.next = null;
		curr1.next = dummy2.next;
		return dummy1.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
