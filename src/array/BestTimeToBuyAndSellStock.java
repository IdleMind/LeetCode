package array;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Aug 6, 2014
  
  Problem:    Best Time to Buy and Sell Stock 
  Source:     https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
  Difficulty: Easy
  
  Key Idea:   one pass scan
*/

public class BestTimeToBuyAndSellStock {
  public static class Solution {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length <= 1) {
        return 0;
      }
      
      int min = prices[0];
      int profit = 0;
      
      for (int i = 0; i < prices.length; i++) {
        min = Math.min(min, prices[i]);
        profit = Math.max(profit, prices[i] - min);
      }
      
      return profit;
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maxProfit(new int[]{1}));
    System.out.println(s.maxProfit(new int[]{2,3,6,4,5}));
  }
}
