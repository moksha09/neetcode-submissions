class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int buy = 0;
        int sell = buy+1;

        while(buy < sell && sell < prices.length){
            int profit = prices[sell] - prices[buy];
            if(profit < 0){
                buy = sell;
            }
            maxProfit = Math.max(maxProfit, profit);
            sell++;
        }
        
        return maxProfit;
    }
}
