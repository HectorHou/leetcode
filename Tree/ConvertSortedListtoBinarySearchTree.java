// 109. Convert Sorted List to Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 88997
// Total Submissions: 274351
// Difficulty: Medium
// Contributors: Admin
// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListtoBinarySearchTree {
    /*
    *Solution:Find the middle node to insert from root by two points.
    */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return toBST(head, null);
    }
    private TreeNode toBST(ListNode head, ListNode tail){
        if (head == tail)
            return null;
        ListNode p1 = head, p2 = head;
        while(p1 != tail && p1.next != tail){
            p1 = p1.next.next;
            p2 = p2.next;
        }
        TreeNode root = new TreeNode(p2.val);
        root.left = toBST(head, p2);
        root.right = toBST(p2.next, tail);
        return root;
    }
}
