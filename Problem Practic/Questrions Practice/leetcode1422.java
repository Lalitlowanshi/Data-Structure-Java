class Solution {

    public static int maxScore(String s) {
        int n = s.length();

        // Count the total number of ones in the string
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        // Traverse the string and calculate the maximum score
        int maxScore = Integer.MIN_VALUE;
        int leftZeros = 0;
        int rightOnes = totalOnes;

        // Iterate through the string until the second last character
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            // Calculate the score for the current split
            int currentScore = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}
