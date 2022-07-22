package lc.daily;

//https://leetcode.com/problems/partition-list/

public class PartitionList {
     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    static class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode leftPartionDummyHead = new ListNode(-1);
            ListNode rightPartionDummyHead = new ListNode(-1);
            ListNode partionConnector = leftPartionDummyHead;
            ListNode tailNode = rightPartionDummyHead;

            ListNode iterNode = head;
            while(iterNode!=null) {
                ListNode next = iterNode.next;
                if(iterNode.val<x) {
                    //add to leftPartion
                    partionConnector.next = iterNode;
                    partionConnector = iterNode;
                } else {
                    tailNode.next = iterNode;
                    tailNode = iterNode;
                }
//$$$$$ Missing below statement will lead to cycle formation $$$$$
                iterNode.next = null;
                iterNode = next;
            }

            partionConnector.next = rightPartionDummyHead.next;

            return leftPartionDummyHead.next;
        }
    }
}
