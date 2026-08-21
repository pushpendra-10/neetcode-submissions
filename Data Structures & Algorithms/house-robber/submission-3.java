class Solution {
    public int money(int n, int[] nums, int[] dp) {
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int skip = money(n-1, nums, dp);
        int take = nums[n] + money(n-2, nums, dp);
        return dp[n] = Math.max(skip, take);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n>1)dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            int skip = dp[i-1];
            int take = dp[i-2] + nums[i];
            dp[i] = Math.max(skip, take);
        }
        return dp[n-1];
    }
}
