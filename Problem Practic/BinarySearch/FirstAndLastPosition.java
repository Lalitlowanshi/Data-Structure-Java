import java.util.Arrays;

public class FirstAndLastPosition {
    // return the index
// return -1 when target element not found
public static void main(String[] args) {

    int [] arr = {5,7,7,8,8,10};
    int target = 8;

    int [] ans = search_in_range(arr, target);
    System.out.println(Arrays.toString(ans));

}
public static int [] search_in_range (int [] arr , int target) {
    
int[] ans = {-1,-1};
// check for first occurence of target first

ans[0] = search(arr, target, true);
ans[1] = search(arr, target, false);
return ans;
}
// this function just return the index value opf target element
public static int search (int [] arr, int target ,boolean findStartIndex) {
    int ans = -1;
    int start = 0;
int end = arr.length-1;
while (start <= end) {

// int mid = ( start + end ) /2;
int mid = start + (end - start) / 2 ;   // this is efficient way to find mid
if (target < arr [mid]) {
   end = mid-1;
}

else if (target > arr [mid] ) {
    start = mid +1;
}

else{
// potential found answer
ans = mid;
if (findStartIndex) {
    end = mid -1;
}
else{
start = mid+1;
}
}

}
return ans;
}
}
