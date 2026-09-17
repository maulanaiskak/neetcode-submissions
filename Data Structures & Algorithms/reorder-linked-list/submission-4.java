class Solution {
    public void reorderList(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var secondHalf = slow.next;
        slow.next = null;

        ListNode reversedSecondHalf = null;

        while (secondHalf != null) {
            var nextNode = secondHalf.next;
            secondHalf.next = reversedSecondHalf;
            reversedSecondHalf = secondHalf;
            secondHalf = nextNode;
        }

        var firstHalf = head;
        var secondHalfCurrent = reversedSecondHalf;

        while (secondHalfCurrent != null) {
            var firstHalfNext = firstHalf.next;
            var secondHalfNext = secondHalfCurrent.next;

            firstHalf.next = secondHalfCurrent;
            secondHalfCurrent.next = firstHalfNext;

            firstHalf = firstHalfNext;
            secondHalfCurrent = secondHalfNext;
        }
    }
}