// 106. Construct Binary Tree from Inorder and Postorder Traversal QuestionEditorial Solution  My Submissions
// Total Accepted: 72104
// Total Submissions: 233968
// Difficulty: Medium
// Contributors: Admin
// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// Subscribe to see which companies asked this question
//
// Show Tags
// Show Similar Problems


public class ConstructBinaryTreefromInorderandPostorderTraversal {
	/*
	 * Solution:recursion solution.
	 * if the length of inorder and postorder is not 0, then we build the current node and its left and right.
	 * key:find the subinorder and subpostorder.
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;
		int val = postorder[postorder.length - 1];
		TreeNode root = new TreeNode(val);
		int index = search(inorder, val);
		root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
		root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length),
				Arrays.copyOfRange(postorder, index, postorder.length - 1));
		return root;
	}

	private int search(int[] inorder, int val) {
		for (int i = 0; i < inorder.length; i++)
			if (inorder[i] == val)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new ConstructBinaryTreefromInorderandPostorderTraversal()
				.buildTree(new int[] { 4, 2, 5, 1, 6, 3, 7 }, new int[] { 4, 5, 2, 6, 3, 7, 1 }));

	}

}
