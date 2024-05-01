public class Find_min {
    public static void main(String[] args) {
        int [] a ={18,20,25,12,23,-2,85,2};
        int [] b ={18,20,25,12,23,-3,85,2};
        min(a);
        System.out.println(min2(b));
    }
    public static void min(int [] a) {
        int small=a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < small) {
                small = a[i];
            }
        }
        System.out.println(small);
    }
    // By return the value
    public static int min2(int [] a) {
        int small=a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < small) {
                small = a[i];
            }
        }
        return small;
    }

}
