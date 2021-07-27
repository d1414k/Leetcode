// https://leetcode.com/problems/reverse-nodes-in-k-group/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        int count = 0;
        ListNode p = head;
        while(p != null){
            count++;
            if(count == k)
                break;
            p = p.next;
        }
        // in this case we need not to reverse
        if(p == null) return head; 
        ListNode remainingGroupsHead = reverseKGroup(p.next,k);
        // break link
        p.next = null;
        // reverse this group
        ListNode cur = head,prev = null,nex = null;
        while(cur != null){
            nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        // join : earlier head will be now tail
        head.next = remainingGroupsHead;
        return prev;
    }
}
