// 147. Insertion Sort List   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 88002
// Total Submissions: 279059
// Difficulty: Medium
// Contributors: Admin
// Sort a linked list using insertion sort.
//
// Subscribe to see which companies asked this question


public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode sortedHead = head, unsortedHead = head.next;
		sortedHead.next = null;
		while (unsortedHead != null) {
			ListNode node = unsortedHead;
			unsortedHead = unsortedHead.next;
			node.next = null;
			sortedHead = sort(sortedHead, node);
		}

		return sortedHead;
	}

	// insertion sort
	private ListNode sort(ListNode sortedHead, ListNode node) {
		if (node.val <= sortedHead.val) {
			node.next = sortedHead;
			return node;
		}
		ListNode p = sortedHead;
		boolean inserted = false;
		while (p.next != null) {
			if (node.val <= p.next.val) {
				node.next = p.next;
				p.next = node;
				inserted = true;
				break;
			}
			p = p.next;
		}
		if (!inserted)
			p.next = node;
		return sortedHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
