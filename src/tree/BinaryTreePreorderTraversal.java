package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 Author:     Tai Zhou, zhoutai603@gmail.com
 Date:       Jun 22, 2013

 Problem:    Binary Tree Preorder Traversal
 Source:     https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 Difficulty: Easy

 Note:
 Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static class Solution {
    @SuppressWarnings("unchecked")
    public List<Integer> preorderTraversal(TreeNode root) {
      if (root == null) {
        return Collections.EMPTY_LIST;
      } else {
        List<Integer> preorder = new LinkedList<Integer>();
        preorder.add(root.val);
        preorder.addAll(preorderTraversal(root.left));
        preorder.addAll(preorderTraversal(root.right));
        return preorder;
      }
    }
  }
  
  public static class Solution1 {
    @SuppressWarnings("unchecked")
    public List<Integer> preorderTraversal(TreeNode root) {
      if (root == null) {
        return Collections.EMPTY_LIST;
      } else {
        List<Integer> preorder = new LinkedList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        TreeNode current = root;
        while (current != null) {
          preorder.add(current.val);
          stack.push(current);
          current = current.left;
        }
        while (!stack.isEmpty()) {
          current = stack.pop();
          if (current != null) {
            current = current.right;
          }
          while (current != null) {
            preorder.add(current.val);
            stack.push(current);
            current = current.left;
          }
        }
        return preorder;
      }
    }
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = null;
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = null;
    
    Solution1 s = new Solution1();
    
    assert(s.preorderTraversal(root).toString().equals("[5, 4, 3]"));
  }
}
