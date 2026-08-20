class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
    
        int total = 0;
        int i=0;
        while(i<n-1){
            if(buy >= prices[i]){
                buy = prices[i];
            }
            while(i<n-1 && prices[i] <= prices[i+1]){
                i++;
            }
            int sell = prices[i];
            total += sell-buy;
            buy = prices[i];
            i++;
        }
        
        return total;
    }
}