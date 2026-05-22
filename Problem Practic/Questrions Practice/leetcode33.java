class Solution {
    public int search (int [] nums , int target){
        int pivot = findPivot(nums);
     
        if (pivot == -1) {
            //  we can apply normal binary search 
            return BinarySearch(nums, target, 0, nums.length-1);
        }
        // if pivot is found then there is two ascending arrays
        if (nums[pivot] == target) {
            return pivot;
        }
        
        if (target >=  nums [0] ) {
            return BinarySearch(nums, target,0, pivot-1);
        }
            return BinarySearch(nums, target, pivot+1, nums.length -1);
        
    }
    public int BinarySearch(int [] nums , int target , int start , int end){

        while (start <= end){
            int mid = start + (end - start)/2;
            if (target < nums[mid]) {
                end = mid -1;
            }
            else if (target > nums[mid]) {
             
              start = mid +1;
            }
            else {
                // found answer..
                return mid;     
           }
        }
        return -1;
    }

    public int findPivot(int [] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if (mid > start && arr[mid-1] > arr[mid]) {
                return mid-1 ;
            }
            if (arr[mid] <= arr[start]) {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return -1;
    }
}
