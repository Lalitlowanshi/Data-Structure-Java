public class Search_in_rotated_array {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/description/

    public static void main(String[] args) {
        int [] array = {2,2,9,2,2,2,2};
        System.out.println(findPivotWithDuplicate(array));


        int [] a = {4,5,6,7,0,1,2};
        System.out.println(findPivot(a));


        int target = 0;
        System.out.println(search(a, target));
    }
    public static int search (int [] nums , int target){
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
    public static int BinarySearch(int [] nums , int target , int start , int end){

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

    // this function is not able to find pivot in duplicate elements 
    public static int findPivot(int [] arr) {
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


    // trying to make a function that can find the pivot element in duplicate array
public static int findPivotWithDuplicate(int [] arr) {
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
       // if element at middil , start , end are equal then skip the duplicates...[2,2,9,2,2,2,2]
       if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
        // skip the dupkicates
        // NOTE: what if these elements that start and end were pivot??..
        // check if start is pivot or not
        if (arr[start] > arr[start+1]) {
            return start;
        }
        start ++;

        // check weather end is pivot or not
        if (arr[end-1] > arr[end]) {
            return end-1;
        }
        end --;
       }
               // left side is sorted then find in right side
               else if (arr[start] < arr [mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
               }
               else{
                end = mid -1;
               }
            }
    return -1;
}
}