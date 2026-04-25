import java.util.*;

class Solution {

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];

            if (x == 0) pos[i] = y;
            else if (y == side) pos[i] = side + x;
            else if (x == side) pos[i] = 3L * side - y;
            else pos[i] = 4L * side - x;
        }

        Arrays.sort(pos);

        int low = 0, high = side * 2, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(pos, k, mid, side)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(long[] pos, int k, int d, int side) {
        int n = pos.length;
        long perimeter = 4L * side;

        long[] ext = new long[2 * n];
        for (int i = 0; i < n; i++) {
            ext[i] = pos[i];
            ext[i + n] = pos[i] + perimeter;
        }

        for (int start = 0; start < n; start++) {

            int count = 1;
            long last = ext[start];
            int idx = start;

            while (count < k) {
                idx = lowerBound(ext, idx + 1, start + n, last + d);
                if (idx >= start + n) break;

                last = ext[idx];
                count++;
            }

            if (count == k && perimeter - (last - ext[start]) >= d) {
                return true;
            }
        }

        return false;
    }

    private int lowerBound(long[] arr, int l, int r, long target) {
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

//Time Limit Exceed(TLE)........


// import java.util.*;

// class Solution {

//     public int maxDistance(int side, int[][] points, int k) {
//         int n = points.length;

//         // boundary position me convert karenge
//         long[] arr = new long[n];

//         for (int i = 0; i < n; i++) {
//             int x = points[i][0];
//             int y = points[i][1];

//             if (x == 0) arr[i] = y;                         // left side
//             else if (y == side) arr[i] = side + x;         // top side
//             else if (x == side) arr[i] = 3L * side - y;    // right side
//             else arr[i] = 4L * side - x;                   // bottom side
//         }

//         Arrays.sort(arr);

//         int low = 0;
//         int high = side * 2;
//         int ans = 0;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             if (canSelect(arr, k, mid, side)) {
//                 ans = mid;
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return ans;
//     }

//     private boolean canSelect(long[] arr, int k, int dist, int side) {
//         int n = arr.length;
//         long perimeter = 4L * side;

//         for (int start = 0; start < n; start++) {
//             int count = 1;
//             long last = arr[start];

//             for (int i = start + 1; i < n; i++) {
//                 if (arr[i] - last >= dist) {
//                     count++;
//                     last = arr[i];
//                 }

//                 if (count == k) {
//                     if (perimeter - (last - arr[start]) >= dist) {
//                         return true;
//                     }
//                 }
//             }
//         }

//         return false;
//     }
// }
