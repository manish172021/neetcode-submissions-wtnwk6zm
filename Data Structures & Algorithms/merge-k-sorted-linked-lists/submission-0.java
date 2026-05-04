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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return partitionAndMerge(0, lists.length - 1, lists);
    }

    private ListNode partitionAndMerge(int start, int end, ListNode[] lists) {
        if(start == end) {
            return lists[start]; //  return new ListNode();  // This creates a NEW node with value 0
        }
        int mid = start + (end - start)/2;
        ListNode l1 =  partitionAndMerge(start, mid, lists);
        ListNode l2 =  partitionAndMerge(mid + 1, end, lists);
        return mergeTwoSortedLL(l1, l2);
    }

    private ListNode mergeTwoSortedLL(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoSortedLL(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoSortedLL(l1, l2.next);
            return l2;
        }

    }   
}
