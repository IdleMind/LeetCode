package tree;

import java.util.LinkedList;
import java.util.List;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 14, 2014
  
  Problem:    Binary Tree Inorder Traversal
  Source:     https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
  Difficulty: Easy
  
  Key Idea:   BFS
*/

public class BinaryTreeInorderTraversal {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> inorder = new LinkedList<Integer>();
      if (root != null) {
        inorder.addAll(inorderTraversal(root.left));
        inorder.add(root.val);
        inorder.addAll(inorderTraversal(root.right));
      }
      return inorder;
    }
  }
  
  public static class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> inorder = new LinkedList<Integer>();
      
      if (root == null) {
        return inorder;
      }
      
      LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
      TreeNode curNode = root;
      while (curNode != null) {
        stack.push(curNode);
        curNode = curNode.left;
      }
      
      while (!stack.isEmpty()) {
        curNode = stack.pop();
        
        if (curNode != null) {
          inorder.add(curNode.val);
          curNode = curNode.right;
        }
        
        while (curNode != null) {
          stack.push(curNode);
          curNode = curNode.left;
        }
      }
      
      return inorder;
    }
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = null;
    
    Solution1 s = new Solution1();
    System.out.println(s.inorderTraversal(root));
    
    System.out.println(s.inorderTraversal(null));
  }
}
