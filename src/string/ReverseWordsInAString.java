package string;


/*
 Author:     Tai Zhou, zhoutai603@gmail.com
 Date:       Jun 22, 2013

 Problem:    Reverse Words In A String
 Source:     https://oj.leetcode.com/problems/reverse-words-in-a-string/
 Difficulty: Easy

 Clarification:
 1. What constitutes a word?
 A sequence of non-space characters constitutes a word.
 2. Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 3. How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */

public class ReverseWordsInAString {
  public static class Solution {
    public String reverseWords(String s) {
      s = s.trim();
      String[] words = s.split("[\t| |\n]{1,}");

      StringBuilder reversed = new StringBuilder();
      for (int i = words.length - 1; i > 0; --i) {
        reversed.append(words[i] + " ");
      }
      reversed.append(words[0]);

      return reversed.toString();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    assert (s.reverseWords("  abc def    ").equals("def abc"));
  }
}