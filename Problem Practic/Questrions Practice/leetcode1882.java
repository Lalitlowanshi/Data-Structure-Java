
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Available servers: [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: [freeTime, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                if (a[1] != b[1]) {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[2], b[2]);
            }
        );

        // Initially all servers are available
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        for (int i = 0; i < m; i++) {

            // Release all servers that have completed their tasks
            while (!busy.isEmpty() && busy.peek()[0] <= i) {
                long[] server = busy.poll();

                available.offer(new int[]{
                    (int) server[1],
                    (int) server[2]
                });
            }

            // If no server is available, wait for the earliest one
            if (available.isEmpty()) {

                long freeTime = busy.peek()[0];

                while (!busy.isEmpty() &&
                       busy.peek()[0] == freeTime) {

                    long[] server = busy.poll();

                    available.offer(new int[]{
                        (int) server[1],
                        (int) server[2]
                    });
                }
            }

            // Select the best available server
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[i] = index;

            // Calculate when this server will become free
            long freeTime = Math.max(i, busy.isEmpty() ? i : i);

            // Actual task start time
            long startTime = Math.max(i,
                busy.isEmpty() ? i : 0);

            // If task starts after waiting, use earliest free time
            if (busy.size() >= 0) {
                startTime = Math.max(i, freeTime);
            }

            busy.offer(new long[]{
                startTime + tasks[i],
                weight,
                index
            });
        }

        return ans;
    }
}
