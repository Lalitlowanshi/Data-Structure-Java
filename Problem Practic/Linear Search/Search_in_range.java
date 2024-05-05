public class Search_in_range {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7,8,9};
        int target=8;
        int start=1;
        int end = 4;
        int ans = search(arr, target, start,end);
        System.out.println(ans);
    }
    public static int search(int [] a , int target,int start, int end) {
        if (a.length==0) {
            return -1;
        }
        for (int index = start; index <= end; index++) {
            int temp =a[index];
            if (temp==target) {
                return index;
            }
        }
    return -1;
    }
}
