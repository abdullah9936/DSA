class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return; 
        }

        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        
        ListNode ptr1 = head;
        ListNode ptr2 = prev;

        while (ptr2.next != null) { 
            ListNode temp1 = ptr1.next;
            ListNode temp2 = ptr2.next;

            ptr1.next = ptr2;
            ptr2.next = temp1;

            ptr1 = temp1;
            ptr2 = temp2;
        }
    }
}