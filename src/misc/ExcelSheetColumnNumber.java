package misc;

/**
@author     Tai Zhou, zhoutai603@gmail.com
Date:       Jan, 1, 2014

Problem:    Excel Sheet Column Number
Source:     https://oj.leetcode.com/problems/excel-sheet-column-number/
Difficulty: Easy

- Meet in Google's onsite interview.
*/

public class ExcelSheetColumnNumber {
  public static class Solution {
    public int titleToNumber(String s) {
      int number = 0;
      
      if (s == null) { 
        return number;
      }
      
      for (int i = 0; i < s.length(); i++) {
        number *= 26;
        number += s.charAt(i) - 'A' + 1;
      }
      
      return number;
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.titleToNumber("A"));
    System.out.println(s.titleToNumber("AA"));
  }
}
