package tree;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Aug 1, 2014
  
  Problem:    Flatten Binary Tree to Linked List
  Source:     https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
  
  Key Idea:   DFS (pre-order traversal)
*/

public class FlattenBinaryTreeToLinkedList {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    public static class TreeNodeRef {
      TreeNode list;
    }
    
    public void flatten(TreeNode root) {
      if (root == null) {
        return;
      }
      
      TreeNodeRef list = new TreeNodeRef();
      flattenInternal(root, list);
      root = list.list;
    }
    
    private void flattenInternal(TreeNode root, TreeNodeRef list) {
      if (root.right != null) {
        flattenInternal(root.right, list);
      }
      
      if (root.left != null) {
        flattenInternal(root.left, list);
      }
      
      root.right = list.list;
      root.left = null;
      list.list = root;
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
   
    s.flatten(root);
    
    while (root != null) {
      System.out.println(root.val + " ");
      root = root.right;
    }
  }
}

/*
  A in-place solution in the discuss page.
  Combine list iteration and preorder traversal for trees.
  Iterating the list during the generation.
  
  while ( root ) {
      if ( root->left ) {
          TreeNode *ptr = root->left;
          while ( ptr->right ) ptr = ptr->right;
          ptr->right = root->right;
          root->right = root->left;
          root->left = NULL;
      }
      root = root->right;
  }
 */