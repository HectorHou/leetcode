// 95. Unique Binary Search Trees II   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 71560
// Total Submissions: 234511
// Difficulty: Medium
// Contributors: Admin
// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
// Subscribe to see which companies asked this question


public class UniqueBinarySearchTrees {
	/*
	 * Solution:The process of creating a binary search tree is just like a Catalan Number.
	 * 				tree(3) = tree(0) * tree(2) + tree(1) * tree(1) + tree(2) * tree(0)
	 * 			 So we build the tree in this way by DP.
	 * 			 The left child is always the same, so we don't need to modify.
	 * 			 But the right child should be modified by deep copy to change the value to the value plus the root value.
	 */

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = new LinkedList<>();
		if (n == 0)
			return list;
		List<TreeNode>[] res = (List<TreeNode>[]) new List[n + 1];
		res[0] = list;
		res[0].add(null);
		for (int i = 1; i < n + 1; i++) {
			res[i] = new LinkedList<>();
			for (int j = 0; j < i; j++) {
				for (TreeNode l : res[j]) {
					for (TreeNode r : res[i - j - 1]) {
						TreeNode root = new TreeNode(j + 1);
						root.left = l;
						root.right = deepCopy(r, j + 1);
						res[i].add(root);
					}
				}
			}
		}
		return res[n];

	}

	private TreeNode deepCopy(TreeNode r, int i) {
		if (r == null)
			return null;
		TreeNode root = new TreeNode(r.val + i);
		root.left = deepCopy(r.left, i);
		root.right = deepCopy(r.right, i);
		return root;
	}

	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTrees().generateTrees(3));

	}

}
