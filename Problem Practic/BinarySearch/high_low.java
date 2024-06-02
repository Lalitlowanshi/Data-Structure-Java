// https://leetcode.com/problems/guess-number-higher-or-lower/

public class high_low {
    /** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
    int start = 1;
    int end = n;
    while (start <= end) {
    
    // int mid = ( start + end ) /2;
    int mid = start + (end - start) / 2 ;   // this is efficient way to find mid
            if (guess(mid) == -1) {
                end = mid - 1;
            }

            else if (guess(mid) == 1) {
                start = mid + 1;
            }

            else {
                return mid;
            }
        } 
        return 0;
    }
}
}
