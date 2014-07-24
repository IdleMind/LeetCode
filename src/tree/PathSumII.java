package tree;

import java.util.LinkedList;
import java.util.List;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 24, 2014
  
  Problem:    Path Sum II
  Source:     https://oj.leetcode.com/problems/path-sum-ii/
  
  Key Idea:   DFS
*/

public class PathSumII {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  public static class Solution {
    private List<List<Integer>> pathSums;
    
    public Solution() {
      pathSums = new LinkedList<List<Integer>>();
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      if (root == null) {
        return this.pathSums;
      }
      List<Integer> list = new LinkedList<Integer>();
      pathSumInternal(root, sum, list);
      
      return this.pathSums;
    }
    
    private void pathSumInternal(TreeNode root, int sum, List<Integer> list) {
      list.add(root.val);
      
      if (root.left == null && root.right == null) {
        if (root.val == sum) {
          pathSums.add(new LinkedList<Integer>(list));
        } else {
          ;
        }
      }
      
      if (root.left != null) {
        pathSumInternal(root.left, sum - root.val, list);
      }
      
      if (root.right != null) {
        pathSumInternal(root.right, sum - root.val, list);
      }
      
      list.remove(list.size() - 1);
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(s.pathSum(root, 3));
    
    Solution s1 = new Solution();
    root.left.right = new TreeNode(1);
    System.out.println(s1.pathSum(root, 4));
  }
}
