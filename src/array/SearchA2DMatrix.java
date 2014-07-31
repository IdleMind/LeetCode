package array;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 31, 2014
  
  Problem:    Search a 2D Matrix
  Source:     https://oj.leetcode.com/problems/search-a-2d-matrix/
  Difficulty: Easy
  
  Key Idea:   binary search
*/

public class SearchA2DMatrix {
  public static class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null) {
        return false;
      }
      
      int rows = matrix.length;
      int cols = matrix[0].length;
      
      if (rows == 0 || cols == 0) { 
        return false;
      }
      
      int low = 0, high = rows * cols - 1;
      while (low <= high) {
        int mid = low + ((high - low) >> 1);
        int row = mid / cols;
        int col = mid % cols;
        if (matrix[row][col] == target) {
          return true;
        } else if (matrix[row][col] < target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return false;
    }
  }
  
  public static void main(String[] args) {
    int[][] matrix = {{1,3,5,7},{8,9,10,11},{13,15,19,25}};
    Solution s = new Solution();
    System.out.println(s.searchMatrix(matrix, 1));
    System.out.println(s.searchMatrix(matrix, 13));
    System.out.println(s.searchMatrix(matrix, 26));
    System.out.println(s.searchMatrix(matrix, 0));
  }
}
