package dynamicProgramming;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Aug 6, 2014
  
  Problem:    Climbing Stairs 
  Source:     https://oj.leetcode.com/problems/climbing-stairs/
  Difficulty: Easy
  
  Key Idea:   recursion or DP
*/

public class ClimbingStairs {
  public static class Solution {
    public int climbStairs(int n) {
      if (n == 0) {
        return 0;
      }
      if (n == 1) {
        return 1;
      }
      if (n == 2) {
        return 2;
      }
      int[] ways = new int[n];
      ways[0] = 1;
      ways[1] = 2;
      for (int i = 2; i < n; i++) {
        ways[i] = ways[i-1] + ways[i-2];
      }
      
      return ways[n-1];
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.climbStairs(1));
    System.out.println(s.climbStairs(2));
    System.out.println(s.climbStairs(5));
  }
}
