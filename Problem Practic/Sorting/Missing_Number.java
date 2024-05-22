
public class Missing_Number {
    public static void main(String[] args) {
    int [] nums ={9,6,4,2,3,5,7,0,1};
    System.out.println(MissingNo(nums));
    }   
    public static int MissingNo(int [] nums){
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correct]) {
                swap(nums,i, correct);
            }
            else{
                i++;
            }
        }
        // search for first misssing number
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                return index;
            }
        }
        return nums.length;
    }
    public static void swap(int [] nums ,int first ,  int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}