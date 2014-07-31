package linkedlist;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 31, 2014
  
  Problem:    Remove Duplicates from Sorted List
  Source:     https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
  Difficulty: Easy
  
  Key Idea:   two pointers (from Cracking the Coding Interview 150)
*/

public class RemoveDuplicatesFromSortedList {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  
  public static class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null) {
        return null;
      }
      
      ListNode curValue = head;
      ListNode nextValue = head.next;
      while (curValue != null) {
        while (nextValue != null && nextValue.val == curValue.val) {
          nextValue = nextValue.next;
        }
        
        curValue.next = nextValue;
        curValue = nextValue;
      }
      
      return head;
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    
    ListNode head = new ListNode(1);
    traverseList(head);
    s.deleteDuplicates(head);
    traverseList(head);
    
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    traverseList(head);
    s.deleteDuplicates(head);
    traverseList(head);
  }
  
  private static void traverseList(ListNode head) {
    if (head == null) {
      System.out.println("Empty list...");
    } else {
      ListNode curNode = head;
      while (curNode != null) {
        System.out.print(curNode.val + " ");
        curNode = curNode.next;
      }
      System.out.println();
    }
  }
}
