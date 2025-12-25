class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // move both pointers
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }
}
