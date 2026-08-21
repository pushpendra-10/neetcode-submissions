class Solution {
    public int result(int n, int[] dp) {
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = result(n-1, dp) + result(n-2, dp) + result(n-3, dp);
    }
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return result(n, dp);
    }
}