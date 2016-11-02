// 374. Guess Number Higher or Lower   QuestionEditorial Solution  My Submissions
// Total Accepted: 27598
// Total Submissions: 84248
// Difficulty: Easy
// Contributors: Admin
// We are playing the Guess Game. The game is as follows:
//
// I pick a number from 1 to n. You have to guess which number I picked.
//
// Every time you guess wrong, I'll tell you whether the number is higher or lower.
//
// You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
//
// -1 : My number is lower
//  1 : My number is higher
//  0 : Congrats! You got it!
// Example:
// n = 10, I pick 6.
//
// Return 6.


public class GuessNumberHigherorLower {
	private int pick = 6;
	public int guessNumber(int n) {
        int lower = 1, higher = n;
        while (true){
            int x = lower + (higher - lower) / 2;
            int guess = guess(x);
            if (guess == 0)
                return x;
            else if (guess == -1)
                higher = x;
            else
                lower = x + 1;
        }
    }
	private int guess(int x){
		if (x == pick)
			return 0;
		else if ( x < pick)
			return 1;
		else
			return -1;
	}
	public static void main(String[] args) {
		System.out.println(new GuessNumberHigherorLower().guessNumber(10));

	}

}
