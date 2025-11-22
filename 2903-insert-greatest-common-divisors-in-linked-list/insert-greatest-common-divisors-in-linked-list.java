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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        while(temp!= null && temp.next != null){
            int newData = gcd(temp.val,temp.next.val);
            ListNode newNode = new ListNode(newData);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        } 
        
        return head;
    }

    static int gcd(int x, int y){
        while(x>0 && y>0){
            if(x>y) x = x %y;
            else y = y%x;
        }
        if(x == 0) return y;
        else return x;
    }
}