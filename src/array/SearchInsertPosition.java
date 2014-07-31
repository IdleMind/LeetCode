package array;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Jul 31, 2014
  
  Problem:    Search Insert Position 
  Source:     https://oj.leetcode.com/problems/search-insert-position/
  Difficulty: Easy
  
  Key Idea:   binary search
*/

public class SearchInsertPosition {
  public static class Solution {
    
    public int searchInsert(int[] A, int target) {
      return searchInsertInternal(A, 0, A.length - 1, target);
    }
    
    private int searchInsertInternal(int[] A, int low, int high, int target) {
      if (low > high) {
        return low;
      }
      
      int mid = low + ((high - low) >> 1);
      if (A[mid] == target) {
        return mid;
      } else if (A[mid] < target) {
        return searchInsertInternal(A, mid + 1, high, target);
      } else {
        return searchInsertInternal(A, low, mid - 1, target);
      }
    }
  }
  
  public static void main(String[] args) {
    int[] A = {1,3,5,7,9};
    Solution s = new Solution();
    
    assert(s.searchInsert(A, 0) == 0);
    assert(s.searchInsert(A, 1) == 0);
    assert(s.searchInsert(A, 2) == 1);
    assert(s.searchInsert(A, 7) == 3);
    assert(s.searchInsert(A, 8) == 4);
    assert(s.searchInsert(A, 10) == 5);
  }
}
