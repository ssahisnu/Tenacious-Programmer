package lc.daily;


//https://leetcode.com/problems/reverse-linked-list-ii/solution/
//--------------------------------------------------------------------------------------------------//
    //Intuition
// four pointers in order prevLeft leftNode rightNode nextRight

// logic -> head-->....-->prevLeft-->(reverse (leftNode, count))-->leftNode-->nextRight
// TC - O(N) and SC - O(1) but still code is not readable


//same logic but clean code
//public ListNode reverseBetween(ListNode head, int m, int n) {
//
//        // Empty list
//        if (head == null) {
//        return null;
//        }
//
//        // Move the two pointers until they reach the proper starting point
//        // in the list.
//        ListNode cur = head, prev = null;
//        while (m > 1) {
//        prev = cur;
//        cur = cur.next;
//        m--;
//        n--;
//        }
//
//        // The two pointers that will fix the final connections.
//        ListNode con = prev, tail = cur;
//
//        // Iteratively reverse the nodes until n becomes 0.
//        ListNode third = null;
//        while (n > 0) {
//        third = cur.next;
//        cur.next = prev;
//        prev = cur;
//        cur = third;
//        n--;
//        }
//
//        // Adjust the final connections as explained in the algorithm
//        if (con != null) {
//        con.next = prev;
//        } else {
//        head = prev;
//        }
//
//        tail.next = cur;
//        return head;
//        }

//--------------------------------------------------------------------------------------------------//



public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left==right)
            return head;

        ListNode prevLeft = null;
        ListNode rightNode = head;
        ListNode leftNode = head;
        ListNode nextRight = null;
        int curPos = 1;
        while(++curPos<=left) {
            prevLeft = leftNode;
            leftNode = leftNode.next;
        }
        rightNode = leftNode;
        curPos = left;
        int diff = right - left + 1;
        while(++curPos<=right) {
            rightNode = rightNode.next;
        }
        nextRight = rightNode.next;

        ListNode reversedListHead = reverseList(leftNode, diff);
        if(prevLeft != null) {
            prevLeft.next = reversedListHead;
            leftNode.next = nextRight;
            return head;
        }
        else { //ie head is leftNode
            leftNode.next = nextRight;
            return reversedListHead;
        }



    }

    private ListNode reverseList(ListNode node, int reverseCount) {
        ListNode prev = null;

        while(reverseCount-->0) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
