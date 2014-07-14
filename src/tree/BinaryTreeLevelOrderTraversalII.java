package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 14, 2014
  
  Problem:    Binary Tree Level Order Traversal 
  Source:     https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
  Difficulty: Easy
  
  Key Idea:   BFS
*/

public class BinaryTreeLevelOrderTraversalII {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> levels = new LinkedList<List<Integer>>();
      
      if (root == null) {
        return levels;
      }
      
      Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
      Queue<Integer> levelQ = new LinkedList<Integer>();
      int curLevel = -1;
      
      nodeQ.add(root);
      levelQ.add(0);
      
      while (!nodeQ.isEmpty()) {
        TreeNode node = nodeQ.poll();
        int level = levelQ.poll();
        
        if (level != curLevel) {
          curLevel = level;
          levels.add(new LinkedList<Integer>());
        }
        
        levels.get(level).add(node.val);
        
        if (node.left != null) {
          nodeQ.add(node.left);
          levelQ.add(level + 1);
        }
        
        if (node.right != null) {
          nodeQ.add(node.right);
          levelQ.add(level + 1);
        }
      }
      
      Collections.reverse(levels);
      return levels;
    }
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = null;
    
    Solution s = new Solution();
    System.out.println(s.levelOrder(root));
    
    System.out.println(s.levelOrder(null));
  }
}
