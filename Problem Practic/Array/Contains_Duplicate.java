class Solution {
    public boolean hasDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
    }
    return false;
    }
}



// class Solution {
//     public boolean hasDuplicate(int[] nums) {
//         int n = nums.length;
//         Set <Integer> set = new HashSet<>();

//         for(int i=0; i<n; i++){
//             set.add(nums[i]);
//         }

//         if(n != set.size()){
//             return true;
//         }
//         return false;
//     }
// }

// class Solution {
//     public boolean hasDuplicate(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         for(int i=0; i<n-1; i++){
//             if(nums[i] == nums[i+1])
//                 return true;
//         }
//         return false;
//     }
// }
