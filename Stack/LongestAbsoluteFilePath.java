//388. Longest Absolute File Path   QuestionEditorial Solution  My Submissions
//Total Accepted: 12205
//Total Submissions: 36565
//Difficulty: Medium
//Contributors: Admin
//Suppose we abstract our file system by a string in the following manner:
//
//The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
//
//dir
//    subdir1
//    subdir2
//        file.ext
//The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
//
//The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
//
//dir
//    subdir1
//        file1.ext
//        subsubdir1
//    subdir2
//        subsubdir2
//            file2.ext
//The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
//
//We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
//
//Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.
//
//Note:
//The name of a file contains at least a . and an extension.
//The name of a directory or sub-directory will not contain a ..
//Time complexity required: O(n) where n is the size of the input string.
//
//Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
public class LongestAbsoluteFilePath {
	/*
	 * Solution: Split the input by "\n" which means every line is a folder or a file.
	 * 			   Use Stack to manage them.
	 * 					If the line has more "\t" than the top of the stack, means it is in the folder and can be push in the stack.
	 * 					else we get the deepest in the folder than we can calculate the length and then pop the top and do the first step
	 */

	public int lengthLongestPath(String input) {
		if (input == null || !input.contains("."))
			return 0;

		String[] ss = input.split("\n");
		Stack<String> stack1 = new Stack<>();

		int maxLen = 0, len = 0;

		for (int i = 0; i < ss.length; i++) {
			int index = ss[i].lastIndexOf("\t");
			if (stack1.isEmpty() || stack1.peek().lastIndexOf("\t") < index) {
				len += (ss[i].length() - index - (stack1.isEmpty() ? 1 : 0));
				stack1.push(ss[i]);
			} else {
				if (stack1.peek().contains("."))
					maxLen = len > maxLen ? len : maxLen;
				while (!stack1.isEmpty() && stack1.peek().lastIndexOf("\t") >= index) {
					String s = stack1.pop();
					len -= (s.length() - (stack1.isEmpty() ? 0 : s.lastIndexOf("\t")));
				}
				len += (ss[i].length() - index - (stack1.isEmpty() ? 1 : 0));
				stack1.push(ss[i]);
			}
		}
		if (stack1.peek().contains("."))
			maxLen = len > maxLen ? len : maxLen;
		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestAbsoluteFilePath().lengthLongestPath(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

		System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("dir\n        file.txt"));
	}

}