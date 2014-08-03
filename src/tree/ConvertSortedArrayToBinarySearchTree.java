package tree;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Aug 3, 2014
  
  Problem:    Convert Sorted Array to Binary Search Tree
  Source:     https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
  Difficulty: Easy
  
  Key Idea:   DFS
*/

public class ConvertSortedArrayToBinarySearchTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
  public static class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
      if (num == null || num.length == 0) {
        return null;
      }
      
      return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }
    
    private TreeNode sortedArrayToBSTHelper(int[] num, int left, int right) {
      if (left > right) {
        return null;
      }
      
      int mid = left + ((right - left) >> 1);
      TreeNode root = new TreeNode(num[mid]);
      root.left = sortedArrayToBSTHelper(num, left, mid - 1);
      root.right = sortedArrayToBSTHelper(num, mid + 1, right);
      
      return root;
    }
  }
  
  private static void preOrderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.println(root.val);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }
  public static void main(String[] args) {
    Solution s = new Solution();
    
    TreeNode root = s.sortedArrayToBST(new int[]{1,2,3,4,5});
    preOrderTraversal(root);
  }
}
