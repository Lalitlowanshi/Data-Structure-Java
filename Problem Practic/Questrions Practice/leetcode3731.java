class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}

// class Solution {
//     public List<Integer> findMissingElements(int[] nums) {
//         ArrayList<Integer> list = new ArrayList<>();
//         for (int num : nums) {
//             list.add(num);
//         }
//         ArrayList<Integer> result = new ArrayList<>();
//         int n = nums.length;
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;

//         for(int i=0; i<n; i++){
//             if(nums[i] < min){
//                 min = nums[i];
//             }
//             if(nums[i] > max){
//                 max = nums[i];
//             }
//         }
//         for(int i= min; i<=max; i++){
//             if(!list.contains(i)){
//                 result.add(i);
//             }
//         }
//         return result;
//     }
// }
