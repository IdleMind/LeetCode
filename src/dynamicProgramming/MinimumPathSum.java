package dynamicProgramming;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 31, 2014
  
  Problem:    Minimum Path Sum
  Source:     https://oj.leetcode.com/problems/minimum-path-sum/
  Difficulty: Easy
  
  Key Idea:   dynamic programming
              dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
*/

public class MinimumPathSum {
  public static class Solution {
    public int minPathSum(int[][] grid) {
      int rows = grid.length;
      int cols = grid[0].length;
      
      if (grid == null || rows == 0 || cols == 0) {
        return 0;
      }
       
      int[][] dp = new int[rows][cols];
      dp[0][0] = grid[0][0];
      for (int i = 1; i < rows; i++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
      }
      for (int j = 1; j < cols; j++) {
        dp[0][j] = dp[0][j - 1] + grid[0][j];
      }
      
      for (int i = 1; i < rows; i++) {
        for (int j = 1; j < cols; j++) {
          int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
          dp[i][j] = min + grid[i][j];
        }
      }
      
      return dp[rows - 1][cols - 1];
    }
  }
  
  public static void main(String[] args) {
    int[][] grid = {{1,2}, {2,2}};
    Solution s = new Solution();
    System.out.println(s.minPathSum(grid));
  }
}
