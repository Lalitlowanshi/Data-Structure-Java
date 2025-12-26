class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        // Step 1: initial penalty (close at hour 0)
        for (char c : customers.toCharArray()) {
            if (c == 'Y') penalty++;
        }

        int minPenalty = penalty;
        int bestHour = 0;

        // Step 2: try closing at hour j (1 to n)
        for (int j = 1; j <= customers.length(); j++) {
            char prev = customers.charAt(j - 1);

            if (prev == 'Y') {
                penalty--;   // was closed, now open
            } else {
                penalty++;   // open but no customer
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j;
            }
        }

        return bestHour;
    }
}
