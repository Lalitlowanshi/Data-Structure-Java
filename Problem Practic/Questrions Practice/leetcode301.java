import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        int left = 0;
        int right = 0;

        // Find minimum removals
        for (char c : s.toCharArray()) {

            if (c == '(') {
                left++;

            } else if (c == ')') {

                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, 0,
            new StringBuilder(), result);

        return result;
    }

    private void dfs(String s,
                     int index,
                     int leftRemove,
                     int rightRemove,
                     int balance,
                     StringBuilder path,
                     List<String> result) {

        // Invalid parentheses
        if (balance < 0) {
            return;
        }

        // End
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                result.add(path.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // ---------------------------
        // REMOVE CURRENT CHARACTER
        // ---------------------------

        if (c == '(' && leftRemove > 0) {

            // Skip duplicate removal only if
            // previous identical character was NOT removed
            if (index == 0 ||
                s.charAt(index - 1) != '(' ||
                path.length() == 0 ||
                path.charAt(path.length() - 1) != '(') {

                dfs(s,
                    index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    path,
                    result);
            }
        }

        if (c == ')' && rightRemove > 0) {

            if (index == 0 ||
                s.charAt(index - 1) != ')' ||
                path.length() == 0 ||
                path.charAt(path.length() - 1) != ')') {

                dfs(s,
                    index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    path,
                    result);
            }
        }

        // ---------------------------
        // KEEP CURRENT CHARACTER
        // ---------------------------

        path.append(c);

        if (c == '(') {

            dfs(s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                path,
                result);

        } else if (c == ')') {

            dfs(s,
                index + 1,
                leftRemove,
                rightRemove,
                balance - 1,
                path,
                result);

        } else {

            dfs(s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                path,
                result);
        }

        path.deleteCharAt(path.length() - 1);
    }
}
