package tree;

import java.util.Arrays;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 14, 2014
  
  Problem:    Construct Binary Tree from Preorder and Inorder Traversal 
  Source:     https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
  Difficulty: Easy
  
  Key Idea:   Partition the inorder sequence.
  Assume:     No duplicate value in the BT
*/

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      TreeNode root = null;
      
      if (preorder == null || inorder == null 
          || preorder.length == 0 || inorder.length == 0) {
        return root;
      }
      
      int rootVal = preorder[0];
      int rootIndex = 0;
      for( ; rootIndex < inorder.length; rootIndex++) {
        if (inorder[rootIndex] == rootVal) {
          break;
        }
      }
      
      root = new TreeNode(rootVal);
      int left = rootIndex;
      int right = inorder.length - rootIndex;
      int[] preOrderLeft = Arrays.copyOfRange(preorder, 1, left + 1);
      int[] preOrderRight = Arrays.copyOfRange(preorder, rootIndex + 1, rootIndex + right);
      int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
      int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, rootIndex + right);
      root.left = buildTree(preOrderLeft, inorderLeft);
      root.right = buildTree(preOrderRight, inorderRight);
      
      return root;
    }
  }
  
  public static void main(String[] args) {
    int[] preorder = {3, 1};
    int[] inorder = {3, 1};
    
    TreeNode root = new Solution().buildTree(preorder, inorder);
    System.out.println(root.val);
    // System.out.println(root.left.val);
    System.out.println(root.right.val);
  }
}
