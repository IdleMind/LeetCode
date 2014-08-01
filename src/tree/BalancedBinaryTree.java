package tree;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Aug 1, 2014
  
  Problem:    Balanced Binary Tree
  Source:     https://oj.leetcode.com/problems/balanced-binary-tree/
  Difficulty: Easy
  
  Key Idea:   DFS
*/

public class BalancedBinaryTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static class Solution {
    public static class Height {
      int height;
    }
    public boolean isBalanced(TreeNode root) {
      if (root == null) {
        return true;
      }

      Height height = new Height();
      return isBalancedInternal(root, height);
    }

    private boolean isBalancedInternal(TreeNode root, Height height) {
      if (root == null) {
        height.height = 0;
        return true;
      }

      Height leftHeight = new Height();
      Height rightHeight = new Height();
      boolean isBalanced = isBalancedInternal(root.left, leftHeight)
          && isBalancedInternal(root.right, rightHeight);
      if (isBalanced == false) {
        return false;
      } else {
        if (Math.abs(leftHeight.height - rightHeight.height) > 1) {
          return false;
        } else {
          height.height = Math.max(leftHeight.height, rightHeight.height) + 1;
          return true;
        }
      }
    }

    public static void main(String[] args) {
      Solution s = new Solution();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      System.out.println(s.isBalanced(root));
      root.right = new TreeNode(3);
      System.out.println(s.isBalanced(root));
    }
  }
}
