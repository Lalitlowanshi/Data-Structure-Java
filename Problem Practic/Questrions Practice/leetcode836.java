class Solution {
    public boolean isRectangleOverlap(int[] rec, int[] rec2) {

        int width = Math.min(rec[2], rec2[2]) 
                  - Math.max(rec[0], rec2[0]);

        int height = Math.min(rec[3], rec2[3]) 
                   - Math.max(rec[1], rec2[1]);

        return width > 0 && height > 0;
    }
}

// Integer Multiplication Problem with below solution : ans = (-1) * (-1) = 1


// Give Wrong Answer for....

// Input : rec1 = [0,0,1,1]
//         rec2 = [2,2,3,3]
// Output : true
// Expected : false


// class Solution {
//     public boolean isRectangleOverlap(int[] rec, int[] rec2) {
//         int ans = (Math.min(rec[2], rec2[2]) - Math.max(rec[0], rec2[0])) * 
//                   (Math.min(rec[3], rec2[3]) - Math.max(rec[1], rec2[1]));

//         if(ans > 0)
//             return true;
//         return false;
//     }
// }
