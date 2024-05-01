public class Linear_search{
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7,8,9};
        int target=5;
        int ans = search(arr, target);
        System.out.println(ans);
    }
    public static int search(int [] a , int target) {
        if (a.length==0) {
            return -1;
        }
        for (int index = 0; index < a.length; index++) {
            int temp =a[index];
            if (temp==target) {
                return index;
            }
        }
    return -1;
    }
}