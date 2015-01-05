package linkedlist;

/**
@author     Tai Zhou, zhoutai603@gmail.com
Date:       Jan, 1, 2014

Problem:    Add Two Numbers
Source:     https://oj.leetcode.com/problems/add-two-numbers/
Difficulty: Easy

Key Idea:   two pointers 
*/

public class AddTwoNumbers {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  
  public static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode currentNode = null;
      ListNode sum = null;
      
      int adder = 0;
      
      while (l1 != null && l2 != null) {
        ListNode tmp = new ListNode((l1.val + l2.val + adder) % 10);
        adder = (l1.val + l2.val + adder) / 10;
        
        if (currentNode == null) {
          currentNode = tmp;
          sum = currentNode;
        } else {
          currentNode.next = tmp;
          currentNode = currentNode.next;
        }
        
        l1 = l1.next;
        l2 = l2.next;
      }
      
      if (l1 != null) {
        while (l1 != null) {
          ListNode tmp = new ListNode((l1.val + adder) % 10);
          adder = (l1.val + adder) / 10;
          if (currentNode == null) {
            currentNode = tmp;
            sum = currentNode;
          } else {
            currentNode.next = tmp;
            currentNode = currentNode.next;
          }
          l1 = l1.next;
        }
      }
      
      if (l2 != null) {
        while (l2 != null) {
          ListNode tmp = new ListNode((l2.val +adder) % 10);
          adder = (l2.val + adder) / 10;
          if (currentNode == null) {
            currentNode = tmp;
            sum = currentNode;
          } else {
            currentNode.next = tmp;
            currentNode = currentNode.next;
          }
          l2 = l2.next;
        }
      }
      
      if (adder > 0) {
        ListNode tmp = new ListNode(adder);
        currentNode.next = tmp;
      }
      
      return sum;
    } 
  }
  
  public static void main(String[] args) {
    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(8);
    
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(9);
    l2.next.next = new ListNode(3);
    
    ListNode sum = new Solution().addTwoNumbers(l1, l2);
    
    while (sum != null) {
      System.out.print(sum.val);
      sum = sum.next;
    }
  }
}
