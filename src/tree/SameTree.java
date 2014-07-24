package tree;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 24, 2014
  
  Problem:    Same Tree
  Source:     https://oj.leetcode.com/problems/same-tree/
  
  Key Idea:   BFS | DFS
*/

public class SameTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
  public static class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
        return true;
      } else if (p != null && q != null) {
        if (p.val == q.val) {
          return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode p = null, q = null;
    System.out.println(s.isSameTree(p, q));
    
    p = new TreeNode(1);
    q = new TreeNode(1);
    System.out.println(s.isSameTree(p, q));
    
    p.left = new TreeNode(2);
    q.right = new TreeNode(2);
    System.out.println(s.isSameTree(p, q));
  }
}
