package misc;

/**
@author     Tai Zhou, zhoutai603@gmail.com
Date:       Jan, 1, 2014

Problem:    Excel Sheet Column Title
Source:     https://oj.leetcode.com/problems/excel-sheet-column-title/
Difficulty: Easy

- Meet in Google's onsite interview.
*/

public class ExcelSheetColumnTitle {
  public static class Solution {
    public String convertToTile(int n) {
      if (n <= 0) {
        return null;
      }
      
      StringBuilder sb = new StringBuilder();
      while (n > 0) {
        int ch = n % 26 == 0 ? 'Z' : n % 26 - 1 + 'A';
        n -= ch - 'A' + 1;
        n /= 26;
        sb.append((char)ch);
      }
      
      sb.reverse();
      
      return sb.toString();
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.convertToTile(1));
    System.out.println(s.convertToTile(26));
    System.out.println(s.convertToTile(27));
  }
}
