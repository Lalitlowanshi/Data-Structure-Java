 public int mincostTickets(int[] days, int[] costs) {
        // Use a set to quickly check if a day is a travel day
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        // The last travel day determines the length of the dp array
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        // Iterate through each day of the year
        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                // If it is not a travel day, cost remains the same as the previous day
                dp[i] = dp[i - 1];
            } else {
                // Calculate the minimum cost by considering the three options
                dp[i] = Math.min(
                    dp[i - 1] + costs[0], // 1-day pass
                    Math.min(
                        dp[Math.max(0, i - 7)] + costs[1], // 7-day pass
                        dp[Math.max(0, i - 30)] + costs[2] // 30-day pass
                    )
                );
            }
        }

        // The answer is the cost for the last travel day
        return dp[lastDay];
    }
