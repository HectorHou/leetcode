//385. Mini Parser   Add to List QuestionEditorial Solution  My Submissions
//Total Accepted: 10442
//Total Submissions: 35065
//Difficulty: Medium
//Contributors: Admin
//Given a nested list of integers represented as a string, implement a parser to deserialize it.
//
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
//Note: You may assume that the string is well-formed:
//
//String is non-empty.
//String does not contain white spaces.
//String contains only digits 0-9, [, - ,, ].
//Example 1:
//
//Given s = "324",
//
//You should return a NestedInteger object which contains a single integer 324.
//Example 2:
//
//Given s = "[123,[456,[789]]]",
//
//Return a NestedInteger object containing a nested list with 2 elements:
//
//1. An integer containing value 123.
//2. A nested list containing two elements:
//    i.  An integer containing value 456.
//    ii. A nested list with one element:
//         a. An integer containing value 789.
//Subscribe to see which companies asked this question

public class MiniParser {
	/*
	 * Solution:
	 * 1.Use a no-data head NestedInteger to simplify the question.
	 * 2.Add a NestedInteger to the stack and the current NestedInteger when meet a '['
	 * 3.Remove a NestedInteger from the stack when meet a ']'
	 * 4.Set flag false when meet '-'
	 * 5.Add the number to the current NestedInteger as a NestedInteger when meet integers
	 */
	public NestedInteger deserialize(String s) {
		NestedInteger res = new NestedInteger();
		if (s.equals(""))
			return res;
		Stack<NestedInteger> stack = new Stack<>();
		stack.push(res);
		boolean flag = true;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				NestedInteger ni = new NestedInteger();
				stack.peek().add(ni);
				stack.push(ni);
			}
			if (c == ']')
				stack.pop();
			if (c >= '0' && c <= '9') {
				int j = i + 1;
				while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9')
					j++;
				int x = Integer.valueOf(s.substring(i, j));
				if (!flag) {
					x = -x;
					flag = !flag;
				}
				stack.peek().add(new NestedInteger(x));
				i = j - 1;
			}
			if (c == '-')
				flag = !flag;
		}
		return res.getList().get(0);

	}

	public static void main(String[] args) {

	}

}

