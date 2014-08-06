package dynamicProgramming;

/**
  @author     Tai Zhou, zhoutai603@gmail.com
  Date:       Aug 6, 2014
  
  Problem:    Best Time to Buy and Sell Stock II
  Source:     https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
  Difficulty: Easy
  
  Key Idea:   greedy & (specify and generalize) (see Cracking the coding interview :
              five methods for tackling algorithm problems)
*/

public class BestTimeToBuyAndSellStockII {
  public static class Solution {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length <= 1) {
        return 0;
      }
      
      int profit = 0;
      int min = prices[0];
      
      for (int i = 1; i < prices.length; i++) {
        if (prices[i-1] > prices[i]) {
          profit += prices[i-1] - min;
          min = prices[i];
        }
      }
      
      profit += prices[prices.length-1] - min;
      
      return profit;
    }
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maxProfit(new int[]{1,2,3,5}));
  }
}
