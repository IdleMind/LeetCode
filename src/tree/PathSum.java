package tree;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 24, 2014
  
  Problem:    Path Sum
  Source:     https://oj.leetcode.com/problems/path-sum/
  
  Key Idea:   DFS
*/

public class PathSum {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
        return false;
      }
     
      // recursion terminate
      if (root.left == null && root.right == null) {
        return root.val == sum;
      } 
      
      boolean has = false;
      if (root.left != null) {
        // recursion on left subtree
        has = hasPathSum(root.left, sum - root.val);
      } 
      if (!has && root.right != null) {
        // recursion on right subtree
        has = hasPathSum(root.right, sum - root.val);
      }
      
      return has;
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    
    TreeNode root = new TreeNode(1);
    System.out.println(s.hasPathSum(root, 0));
    System.out.println(s.hasPathSum(root, 1));
    
    root.left = new TreeNode(2);
    System.out.println(s.hasPathSum(root, 1));
    System.out.println(s.hasPathSum(root, 3));
  }
}
