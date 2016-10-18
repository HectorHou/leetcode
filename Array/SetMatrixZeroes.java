// 73. Set Matrix Zeroes   QuestionEditorial Solution  My Submissions
// Total Accepted: 80859
// Total Submissions: 233065
// Difficulty: Medium
// Contributors: Admin
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
// click to show follow up.
//
// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
      /*
      *Solution : set containsZero true if the first column has 0;
      *           set the first number of each row 0 if current row has 0;
      *           set the first number of each column(except the first column) 0 if current column has 0.
      *           just recover it by the first row, the first column and containsZero
      */

        if (matrix.length == 0 || matrix[0].length == 0)
            return ;
        boolean containsZero = false;

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0)
                containsZero = true;
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--){
            for (int j = matrix[0].length - 1; j >= 1; j--){
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (containsZero)
                matrix[i][0] = 0;
        }
    }
}
