package tree;

import java.util.ArrayList;
import java.util.List;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 24, 2014
  
  Problem:    Validate Binary Search Tree
  Source:     https://oj.leetcode.com/problems/validate-binary-search-tree/
  
  Key Idea:   DFS
*/

public class ValidateBinarySearchTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    private List<Integer> sorted = new ArrayList<Integer>();
    
    public boolean isValidBST(TreeNode root) {
      if (root == null) {
        return true;
      }
      
      BSTInorderTraversal(root);
      
      for (int i = 1; i < sorted.size(); i++) {
        if (sorted.get(i) <= sorted.get(i - 1)) {
          return false;
        }
      }
      
      return true;
    }
    
    private void BSTInorderTraversal(TreeNode root) {
      if (root.left != null) {
        BSTInorderTraversal(root.left);
      }
      sorted.add(root.val);
      if (root.right != null) {
        BSTInorderTraversal(root.right);
      }
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    System.out.println(s.isValidBST(root));
    
    Solution s1 = new Solution();
    root.left.right = new TreeNode(4);
    System.out.println(s1.isValidBST(root));
  }
}
