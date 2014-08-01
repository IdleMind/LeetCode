package tree;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Aug 1, 2014
  
  Problem:    Unique Binary Search Trees
  Source:     https://oj.leetcode.com/problems/unique-binary-search-trees/
  Difficulty: Easy
  
  Key Idea:   recursion or dynamic programming             
*/

public class UniqueBinarySearchTrees {
  public static class Solution {
    public int numTrees(int n) {
      if (n == 0) {
        return 0;
      }
      
      int[] numOfTrees = new int[n + 1];
      numOfTrees[0] = 1;
      
      for (int i = 1; i <= n; i++) {
        int count = 0;
        for (int j = 0; j < i; j++) {
          count += (numOfTrees[j] * numOfTrees[i - j - 1]);
        }
        numOfTrees[i] = count;
      }
      
      return numOfTrees[n];
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.numTrees(0));
    System.out.println(s.numTrees(1));
    System.out.println(s.numTrees(2));
    System.out.println(s.numTrees(3));
  }
}
