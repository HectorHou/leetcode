// 257. Binary Tree Paths   QuestionEditorial Solution  My Submissions
// Total Accepted: 75833
// Total Submissions: 226650
// Difficulty: Easy
// Contributors: Admin
// Given a binary tree, return all root-to-leaf paths.
//
// For example, given the following binary tree:
//
//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:
//
// ["1->2->5", "1->3"]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        helper(result, root, sb);
        return result;
    }

    private void helper(List<String> result, TreeNode root, StringBuilder sb){
        if (root.left == null && root.right == null){
            result.add(new String(sb));
            return;
        }
        if (root.left != null){
            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append("->" + root.left.val);
            helper(result, root.left, sb1);
        }
        if (root.right != null){
            StringBuilder sb2 = new StringBuilder(sb);
            sb2.append("->" + root.right.val);
            helper(result, root.right, sb2);
        }
    }
}
