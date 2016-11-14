// 36. Valid Sudoku   QuestionEditorial Solution  My Submissions
// Total Accepted: 97975
// Total Submissions: 294069
// Difficulty: Easy
// Contributors: Admin
// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//
// A partially filled sudoku which is valid.
//
// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
//
// Subscribe to see which companies asked this question

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> row = new HashSet<>();
			Set<Character> column = new HashSet<>();
			Set<Character> cube = new HashSet<>();

			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !column.add(board[j][i]))
					return false;

				int RowIndex = 3 * (i / 3);
				int ColIndex = 3 * (i % 3);
				if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'
						&& !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
					return false;

			}
		}
		return true;

	}
}
