class Solution {
    public int count(int i, int[] coins, int amount, int[][] dp) {
        if(i == coins.length){
            if(amount == 0) return 0;
            return Integer.MAX_VALUE;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int skip = count(i+1, coins, amount, dp);
        if(coins[i] > amount) return dp[i][amount] = skip;

        int next = count(i, coins, amount-coins[i], dp);
        int pick;
        if(next == Integer.MAX_VALUE) pick = next;
        else pick = next+1;
        return dp[i][amount] = Math.min(skip, pick);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        } 

        int ans = count(0, coins, amount, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
