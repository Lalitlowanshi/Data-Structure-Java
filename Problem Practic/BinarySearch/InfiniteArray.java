public class InfiniteArray {
    public static void main(String[] args) {

        int [] a = {0,2,5,8,9,12,18,22,52,96};
         int target = 12; 
        System.out.println(answer(a, target));

}
public static int answer(int arr[], int target) {
    // first find the range
    // first start with the box size of 2
    int start = 0;
    int end = 1;

    // condition for the target lie in the range 
    while (target > arr[end]) {
        int temp= end + 1; //this is my new start
        // double the box value 
        //  end = previous start - size of box *2
        end = end + (end - start +1)*2;
        start = temp;
    }
    return BinarySearch(arr, target,start,end);
}
public static int BinarySearch (int [] a , int target, int start, int end) {

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
