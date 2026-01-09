
public class Second_smallest {
    public static void main(String[] args) {

        int[] arr = {6, 6, 1, 2, 5, 4, 3, 6, 6, 6};

        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {
                second = min;
                min = arr[i];
            }
            else if (arr[i] > min && arr[i] < second) {
                second = arr[i];
            }
        }

        if (second == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(second);
        }
    }
}


// public class Second_smallest {
//     public static void main(String[] args) {
//         int[] arr = {6, 6, 1, 2, 5, 4, 3, 6, 6, 6};

//         Arrays.sort(arr);

//         int n = arr.length;
//         int min = arr[0];
//         int second = Integer.MAX_VALUE;

//         for (int i = 1; i < n; i++) {
//             if (arr[i] != min) {
//                 second = arr[i];
//                 break;
//             }
//         }

//         if (second == Integer.MAX_VALUE) {
//             System.out.println(-1);
//         } else {
//             System.out.println(second);
//         }
//     }
// }
