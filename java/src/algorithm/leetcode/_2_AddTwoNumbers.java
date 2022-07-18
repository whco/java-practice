package algorithm.leetcode;

public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, cur, next;

        int sum = getSum(0, l1, l2);
        cur = new ListNode(sum % 10);
        head = cur;

        while(!((sum = getSum(sum / 10, l1.next, l2.next)) == 0 && l1.next == null && l2.next == null)){
            next = new ListNode(sum % 10);
            cur.next = next;
            cur = next;
            if(l1.next != null) l1 = l1.next;
            if(l2.next != null) l2 = l2.next;
        }
        return head;
    }
    private int getOrZero(ListNode l){
        return l == null ? 0 : l.val;
    }
    private int getSum(int q, ListNode l1, ListNode l2){
        return q + getOrZero(l1) + getOrZero(l2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}