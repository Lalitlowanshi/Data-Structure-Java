public class Ceiling {
        // In this code we are just returning the value not index element....

    public static void main(String[] args) {
        int [] a = {1,3,4,6,7,12,15,18};
        int target = 4;
        int ans = search (a , target);
        // print smallet greater or equal value of target element 
        System.out.println(ans);
    }

    public static int search(int [] a , int target){

        if (target > a[a.length-1]) {
            return -1;
        }
        
        int start = 0;
        int end = a.length -1;
        
        while (start <= end ) {
            // finding mid element
            int mid = start + (end - start)/2;
            // target present left side to the mid element
            if (a[mid] > target) {
                end = mid -1 ;
            }
            // target present right side to the mid element 
            else if (a[mid] < target) {
                start = mid +1;
            }
            else  {
                // ans found
                //  a[mid] == target....
                return a[mid];
            }
        }
        // return a smallest greater value of target
        return a[start] ;
    }
}
