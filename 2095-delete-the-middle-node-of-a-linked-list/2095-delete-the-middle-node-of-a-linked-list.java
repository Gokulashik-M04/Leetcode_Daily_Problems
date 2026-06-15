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
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        int n = size / 2;
        temp = head;
        while(temp!= null && n - 1 != 0){
            temp = temp.next;
            n--;
        }
        if(temp == null || temp.next == null) return null;
        temp.next = temp.next.next;
        return head;
    }
}