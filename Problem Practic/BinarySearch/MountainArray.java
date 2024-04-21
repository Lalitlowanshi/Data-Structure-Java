public class MountainArray {
    // https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    public static void main(String[] args) {
        int [] arr = {0,10,5,2};
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);
        // output is index value only
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
}