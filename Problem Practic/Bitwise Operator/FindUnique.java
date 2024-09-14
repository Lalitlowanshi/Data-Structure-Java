public class FindUnique {
    public static void main(String[] args) {
        int [] arr = {2,3,4,1,2,1,3,6,4};
        System.out.println(unique(arr));
    }
    public static int unique(int [] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }
        // for (int i : arr) {
        //     ans ^= i;
        // }
        return ans;
    }
}
