// 103. Binary Tree Zigzag Level Order Traversal
//
//    Total Accepted: 81319
//    Total Submissions: 255507
//    Difficulty: Medium
//    Contributors: Admin
//
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// return its zigzag level order traversal as:
//
// [
//  [3],
//  [20,9],
//  [15,7]
// ]
//
// Subscribe to see which companies asked this question


public class BinaryTreeZigzagLevelOrderTraversal {
	/*
	 * Solution : Breadth_First_Search, use flag to check if the current line
	 * need to be reversed, flag = !flag
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null)
			return res;
		List<Integer> integerList = new LinkedList<>();
		List<TreeNode> nodeList = new LinkedList<>();
		integerList.add(root.val);
		nodeList.add(root);
		boolean flag = true;
		while (integerList.size() != 0) {
			res.add(integerList);
			List<Integer> integerList1 = new LinkedList<>();
			List<TreeNode> nodeList1 = new LinkedList<>();
			for (TreeNode node : nodeList) {
				if (node.left != null) {
					nodeList1.add(node.left);
					integerList1.add(node.left.val);
				}
				if (node.right != null) {
					nodeList1.add(node.right);
					integerList1.add(node.right.val);
				}
			}
			nodeList = nodeList1;
			integerList = integerList1;
			if (flag)
				Collections.reverse(integerList);
			flag = !flag;

		}
		return res;

	}

	public static void main(String[] args) {
		int i = 1;
		TreeNode p = new TreeNode(i++), root = p;
		while (i <= 10) {
			p.left = new TreeNode(i++);
			p.right = new TreeNode(i++);
			p = p.left;
		}
		System.out.println(1);
		System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
	}

}

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
