public class Order_Agnostic_BS {
    
    public static void main(String[] args) {

        // int [] a = {-12,-8,-2,0,2,5,8,9,12,18,22,52,96,99};
        int [] a = {87,78,65,56,54,12,3,2,1,-2,-5,-81,-89};
        int target = 2;

        int ans = orderagnostic(a, target);
        System.out.println(ans);
}
public static int orderagnostic (int [] a , int target) {

   int start = 0;
   int end = a.length-1;
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
