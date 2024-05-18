import java.util.ArrayList;
import java.util.List;

public class AllMssingNumber {
    public static void main(String[] args) {
        int [] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        // searching for the all missing elements that are not available in the array 
        while (i < nums.length) {
            int correct = nums[i] -1;
            if ( nums[i] != nums[correct]) {
                swap(nums,i, correct);
            }
            // else if (nums[i] == nums[correct]) {
            //     i++;
            // }
            else{
                i++;
            }
        }
             // search for first misssing number
             List<Integer> ans = new ArrayList<>();
             for (int index = 0; index < nums.length; index++) {
                if (nums[index] != index +1) {
                    ans.add(index+1);
                }
             }
             return ans;
            }
    
    public static void swap(int [] nums ,int first ,  int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
