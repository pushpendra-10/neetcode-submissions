class Solution {
    public int minCost(int i, int[] cost, int[] dp) {
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i] = cost[i] + Math.min(minCost(i+1, cost, dp), minCost(i+2, cost, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(minCost(0, cost, dp), minCost(1, cost, dp));
    }
}
