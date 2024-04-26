public class Search_in_mountain {
    // https://leetcode.com/problems/find-in-mountain-array/
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,3,1};
        int target = 3;
        int ans = search(arr, target);
        System.out.println(ans);
        // output is index value only
    }
    public static int search(int [] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int first_try = orderagnostic(arr, target, 0, peak);
        if (first_try != -1) {
            return first_try;
        }
        // otherwise try to search in second half 
        return orderagnostic(arr, target, peak+1, arr.length-1);
        
    }
 
   public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
       while (start < end) {
        
        // int mid = ( start + end ) /2;
        int mid = start + (end - start) / 2 ;   // this is efficient way to find mid
     
        if (arr[mid] > arr[mid+1]) {
            // you are in dec part of array 
            // this may be the ans , but first chech to the left
            // that is why end != mid-1;
            end = mid;
        }
        else{
            // you are ascending part of array 
            start = mid+1; // becuse we know the mid+1 > the mid element
        }
         }
         //in the end the start and end both pointing the largest (same) element because of the above two checks
        //  start and end always try to find the max in the above two checks 
        //hence, when they are pointing the one elment , that is the max one, because that is what our checks say
        // more elaboration: at every point of time for start and end , they have the best possible answer till that time
        // and if we are saying only one item is remaining ,hence because of the above lines that is the possible answer
        
        return start;//or return the end s both are equal..
    }


    public static int orderagnostic (int [] a , int target, int start , int end) {

     //    this is also a better way to find ascending or descending
     
        boolean isAscending = a[start] < a[end];
     //    boolean isAscending;
     //    if (a[start] < a[end]) {
     //     isAscending = true;
     //    }
     //    else 
     //    isAscending = false;
     
        while (start <= end) {
        
        // int mid = ( start + end ) /2;
        int mid = start + (end - start) / 2 ;   // this is efficient way to find mid
     
        if (a[mid] == target ) {
         // Ans found
         return mid;
        }
        if (isAscending) {
         
         if (target < a [mid]) {
             end = mid-1;
         }
      
         else  {
             start = mid +1;
         }
        }
        else {
     
        if (target > a [mid]) {
            end = mid-1;
        }
     
        else {
            start = mid +1;
        }
     }
        }
        return -1;
     }
}
