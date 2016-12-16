// 113. Path Sum II   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 106361
// Total Submissions: 341587
// Difficulty: Medium
// Contributors: Admin
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]


public class PathSumII {
	/*
	 * Solution:Got an idea from DFS and BackTracing.
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null)
			return res;
		List<Integer> list = new LinkedList<>();
		list.add(root.val);
		DFS(res, list, root, sum - root.val);

		return res;

	}

	private void DFS(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
		if (sum == 0 && root.left == null && root.right == null) {
			res.add(new LinkedList<>(list));
			return;
		}
		if (root.left != null) {
			list.add(root.left.val);
			DFS(res, list, root.left, sum - root.left.val);
			((LinkedList<Integer>) list).removeLast();
		}
		if (root.right != null) {
			list.add(root.right.val);
			DFS(res, list, root.right, sum - root.right.val);
			((LinkedList<Integer>) list).removeLast();
		}
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(1);
		node.right = new TreeNode(2);
		System.out.println(new PathSumII().pathSum(node, 2));
	}

}
