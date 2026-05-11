import java.util.*;

class Solution {
    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            // Store digits temporarily
            Stack<Integer> stack = new Stack<>();

            while (num != 0) {
                stack.push(num % 10);
                num /= 10;
            }

            // Reverse back to original order
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
        }

        // Convert List<Integer> to int[]
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
