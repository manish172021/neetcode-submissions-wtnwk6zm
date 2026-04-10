/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(n != 0) {
            fast = fast.next;
            n--;
        }
        while(fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev != null) {
            prev.next = slow.next;
        }
        else {
            return head.next;
        }
        return head;

    }
}
