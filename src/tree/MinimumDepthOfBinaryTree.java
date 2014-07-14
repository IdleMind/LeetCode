package tree;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 14, 2014
  
  Problem:    Minimum Depth of Binary Tree
  Source:     https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
  Difficulty: Easy
  
  Note:
  Recursive solution is trivial, could you do it iteratively?
  
  Key Idea: DFS or BFS
*/

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    public int minDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      
      Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
      Queue<Integer> depthQ = new LinkedList<Integer>();
      TreeNode node = root;
      int depth = 1;
      
      nodeQ.add(root);
      depthQ.add(1);
      
      while (!nodeQ.isEmpty()) {
        node = nodeQ.poll();
        depth = depthQ.poll();
        
        if (node.left != null) {
          nodeQ.add(node.left);
          depthQ.add(depth + 1);
        }
        
        if (node.right != null) {
          nodeQ.add(node.right);
          depthQ.add(depth + 1);
        }
        
        if (node.left == null && node.right == null) {
          break;
        }
      }
      
      return depth;
    }
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = null;
    
    Solution s = new Solution();
    System.out.println(s.minDepth(root));
  }
}
