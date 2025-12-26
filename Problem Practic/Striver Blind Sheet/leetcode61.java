class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: find length and tail
        ListNode curr = head;
        int length = 1;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // curr is tail
        curr.next = head;  // Step 2: make circular

        // Step 3: find new tail
        k = k % length;
        int stepsToNewTail = length - k - 1;

        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 4: break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
