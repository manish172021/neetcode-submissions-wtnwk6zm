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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) return null;
        int v1 = 0, v2 = 0;
        if(l1 != null) v1 = l1.val;
        if(l2 != null) v2 = l2.val;
        int data = v1 + v2 + carry;
        ListNode ans = new ListNode(data % 10);
        ans.next = addTwoNumbers((l1 != null) ? l1.next : null, (l2 != null) ? l2.next : null, data/10);
        return ans;
    }
}
