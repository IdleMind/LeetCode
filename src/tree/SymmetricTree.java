package tree;

import java.util.LinkedList;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 24, 2014
  
  Problem:    Symmetric Tree
  Source:     https://oj.leetcode.com/problems/symmetric-tree/
  
  Key Idea:   BFS | DFS
*/

public class SymmetricTree {
  
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }
      
      LinkedList<TreeNode> leftQ = new LinkedList<TreeNode>();
      LinkedList<TreeNode> rightQ = new LinkedList<TreeNode>();
      leftQ.add(root.left);
      rightQ.add(root.right);
      
      while (!leftQ.isEmpty()) {
        TreeNode lNode = leftQ.poll();
        TreeNode rNode = rightQ.poll();
        
        if (lNode == null && rNode == null) {
          continue;
        } else if (lNode != null && rNode != null) {
          if (lNode.val == rNode.val) {
            leftQ.add(lNode.left);
            leftQ.add(lNode.right);
            rightQ.add(rNode.right);
            rightQ.add(rNode.left);
          } else {
            return false;
          }
        } else {
          return false;
        }
      }
      return true;
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = new TreeNode(5);
    System.out.println(s.isSymmetric(root));
    
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    System.out.println(s.isSymmetric(root));
    
    root.left.left = new TreeNode(3);
    System.out.println(s.isSymmetric(root));
  }
}
