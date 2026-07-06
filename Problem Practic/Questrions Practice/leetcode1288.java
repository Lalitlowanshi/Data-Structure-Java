class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;
        boolean[] removed = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j &&
                    intervals[i][0] <= intervals[j][0] &&
                    intervals[i][1] >= intervals[j][1]) {

                    // Don't remove both if intervals are identical
                    if (intervals[i][0] == intervals[j][0] &&
                        intervals[i][1] == intervals[j][1]) {
                        if (i < j)
                            removed[j] = true;
                    } else {
                        removed[j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                count++;
            }
        }

        return count;
    }
}


// Wrong Approch : 

// intervals[j][0] = 0;
// intervals[j][1] = 0;

// because 0 is a valid interval endpoint.


// class Solution {
//     public int removeCoveredIntervals(int[][] intervals) {
//         int n = intervals.length;
//         int count = 0;

//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 if( i != j && intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]){
//                     intervals[j][0] = 0;
//                     intervals[j][1] = 0;
//                    }
//             }
//         }
//         for(int i=0; i<n; i++){
//             if(intervals[i][0] != 0 && intervals[i][1] != 0){
//                 count++;
//             }
//         }
//         return count;
//     }
// }
