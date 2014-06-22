package string;

/*
 Author:     Tai Zhou, zhoutai603@gmail.com
 Date:       Jun 22, 2013

 Problem:    Valid Palindrome
 Source:     https://oj.leetcode.com/problems/valid-palindrome/
 Difficulty: Easy

 Note:
 Have you consider that the string might be empty? 
 This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */

public class ValidPalindrome {

  public static class Solution {
    public boolean isPalindrome(String s) {
      if (s == null) {
        return true;
      } else {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
          while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left)) ) {
            ++left;
          }
          while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
            --right;
          }
          // make sure the indices are valid
          if (left < right 
              && Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
            ++left;
            --right;
          } else {
            break;
          }
        }
        return right <= left;
      }
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    assert(s.isPalindrome(" ") == true);
    assert(s.isPalindrome(" abc ,,,cba///") == true);
    assert(s.isPalindrome(" abc ,,d,cba///") == true);
    assert(s.isPalindrome(" abc ,,,ca///") == false);
  }
}
