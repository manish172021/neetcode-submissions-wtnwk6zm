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
    // O(n) T(1)

    // 2 4 6 8 10
    //     s    f
    // 2 4 10 8 6

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode headM = reverseLL(slow.next);
        slow.next = null;  // IMPORTANT: split list

        // 3. Merge two halves
        ListNode h1 = head;
        ListNode h2 = headM;

        while (h2 != null) {
            ListNode t1 = h1.next;
            ListNode t2 = h2.next;
            h1.next = h2;
            h2.next = t1;
            h1 = t1;
            h2 = t2;
        }
    }

    private ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode smallAns = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return smallAns;
    }
    
}
