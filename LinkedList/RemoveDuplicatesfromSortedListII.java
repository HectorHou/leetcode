package com.hm;
//82. Remove Duplicates from Sorted List II
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 107609
//        Total Submissions: 368239
//        Difficulty: Medium
//        Contributor: LeetCode
//        Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//        For example,
//        Given 1->2->3->3->4->4->5, return 1->2->5.
//        Given 1->1->1->2->3, return 2->3.
//
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Linked List

/**
 * Created by hm on 17-6-20.
 */
public class RemoveDuplicatesfromSortedListII {
    /*
    Solution: 1.use deleteValue to store the value of node need to delete.
              2.for convenience, use new head node head0 and tail0
              3.update deleteValue for each movement and add after tail0 if current node do not equal to deleteValue.
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode head0 = new ListNode(0);
        ListNode tail0 = head0;
        ListNode p = head, q = head.next;
        int deleteValue = -1;
        boolean mean = false;

        while (q != null) {
            if (p.val == q.val) {
                deleteValue = p.val;
                mean = true;
            }
            if (!mean || p.val != deleteValue) {
                tail0.next = p;
                tail0 = p;
            }
            p = q;
            q = q.next;
        }
        if (!mean || p.val != deleteValue) {
            tail0.next = p;
            tail0 = p;
        }

        tail0.next = null;
        return head0.next;
    }

    public static void main(String[] args) {

    }
}
