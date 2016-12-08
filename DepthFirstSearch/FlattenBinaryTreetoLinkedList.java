// 114. Flatten Binary Tree to Linked List   QuestionEditorial Solution  My Submissions
// Total Accepted: 103720
// Total Submissions: 313168
// Difficulty: Medium
// Contributors: Admin
// Given a binary tree, flatten it to a linked list in-place.
//
// For example,
// Given
//
//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
// click to show hints.
//
// Hints:
// If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  /*
  *Solution : We start from the left-bottom node.
  *       every time we put the left prev to the root's right and set root's left null.
  *       then update the prev to the root.
  *
  *       I think it's similar to add a node to the front of a linked list.
  */
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
