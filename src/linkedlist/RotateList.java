package linkedlist;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Aug 2, 2014
  
  Problem:    Rotate List
  Source:     https://oj.leetcode.com/problems/rotate-list/
  Difficulty: Easy
  
  Key Idea:   two pointers 
*/

public class RotateList {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  
  public static class Solution {
    public ListNode rotateRight(ListNode head, int n) {
      if (head == null || n == 0) {
        return head;
      }
      
      int len = 0;
      for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
        len++;
      }
      
      n = n % len;
      if (n == 0) {
        return head;
      }
      
      ListNode newHead = head;
      ListNode preNewHead = null;
      
      for (int i = 1; i < len - n; i++) {
        newHead = newHead.next;
      }
      preNewHead = newHead;
      newHead = newHead.next;
      preNewHead.next = null;
      
      ListNode curNode = newHead;
      while (curNode.next != null) {
        curNode = curNode.next;
      }
      
      curNode.next = head;
      
      return newHead;
    }
  }
  
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    
    Solution s = new Solution();
    
    ListNode newHead = s.rotateRight(head, 2);
    while (newHead != null) {
      System.out.println(newHead.val);
      newHead = newHead.next;
    }
  }
}
