class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDist = Integer.MAX_VALUE;
        int first = -1;
        int prevCritical = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        while (curr != null && curr.next != null) {
            // Check if curr is a critical point
            boolean isCritical =
                    (curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val);

            if (isCritical) {
                if (first == -1) {
                    // First critical point
                    first = index;
                } else {
                    // Distance from previous critical point
                    minDist = Math.min(minDist, index - prevCritical);
                }

                prevCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Need at least two critical points
        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        int maxDist = prevCritical - first;

        return new int[]{minDist, maxDist};
    }
}
