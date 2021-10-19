// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return null;
        for(Node p = head ; p != null ; p = p.next) {
           if(p.child == null)
               continue;
            Node t = flatten(p.child);
            p.child = null;
            Node next = p.next;
            p.next = t;
            t.prev = p;
            if(next == null) break;
            while(t.next != null)
                t = t.next;
            t.next = next;
            next.prev = t;
            p = t;
        }
        return head;
    }
}
