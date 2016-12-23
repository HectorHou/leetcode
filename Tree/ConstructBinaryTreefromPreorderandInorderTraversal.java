// 105. Construct Binary Tree from Preorder and Inorder Traversal   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 84750
// Total Submissions: 276814
// Difficulty: Medium
// Contributors: Admin
// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// Subscribe to see which companies asked this question


public class ConstructBinaryTreefromPreorderandInorderTraversal {
	/*
	 * Solution : Use the same idea as create a tree by inorder and postorder traversal.
	 * 				For not copying the array, this time I use the start and end index.
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);

	}

	private TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
		if (l1 == r1)
			return null;
		int val = preorder[l1];
		TreeNode root = new TreeNode(val);
		int index = findIndex(inorder, val);
		root.left = buildTree(preorder, l1 + 1, l1 + 1 + index - l2, inorder, l2, index);
		root.right = buildTree(preorder, l1 + 1 + index - l2, r1, inorder, index + 1, r2);
		return root;
	}

	private int findIndex(int[] inorder, int val) {
		for (int i = 0; i < inorder.length; i++)
			if (inorder[i] == val)
				return i;
		return -1;
	}

	public static void main(String[] args) {

	}

}
