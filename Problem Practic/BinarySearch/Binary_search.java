public class Binary_search{
// return the index
// return -1 when target element not found
    public static void main(String[] args) {

        int [] a = {-12,-8,-2,0,2,5,8,9,12,18,22,52,96};
         int target = 12; 

         int ans = BinarySearch(a, target);
         System.out.println(ans);
    
}
public static int BinarySearch (int [] a , int target) {

    int start = 0;
    int end = a.length-1;
    while (start <= end) {
    
    // int mid = ( start + end ) /2;
    int mid = start + (end - start) / 2 ;   // this is efficient way to find mid

    if (target < a [mid]) {
        end = mid-1;
    }

    else if (target > a [mid] ) {
        start = mid +1;
    }
    
    else{
    // found answer
    return mid;
    }

    }
    return -1;
}
}