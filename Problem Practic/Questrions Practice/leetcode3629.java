import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        // prime -> indices divisible by that prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int x = nums[i];

            for (int p = 2; p * p <= x; p++) {

                if (x % p == 0) {

                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);

                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }

            if (x > 1) {
                map.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                // left
                if (idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // right
                if (idx + 1 < n && !vis[idx + 1]) {
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // prime teleport
                int val = nums[idx];

                if (isPrime(val) && map.containsKey(val)) {

                    for (int next : map.get(val)) {

                        if (!vis[next]) {
                            vis[next] = true;
                            q.offer(next);
                        }
                    }

                    map.remove(val);
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}



// Wrong Logic (Direct Simulation).........

// class Solution {
//     public int minJumps(int[] nums) {
//         int n = nums.length;
//         int count = 0;
//         for(int i=0; i<n; i++){
//             if(isprime(nums[i])){
//                 for(int j=n-1; j>i; j--){
//                     if(nums[j] % nums[i] == 0){
//                         count++;
//                         i = j;
//                         break;
//                     }
//                 }
//             }
//             count++;
//         }
//         return count-1;
//     }

//     public boolean isprime(int n){
//         if(n<=1){
//             return false;
//         }
//         for(int i=2; i<=n/2; i++){
//             if(n%i == 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
