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
        Arrays.fill(dp, -1);
        return money(n-1, nums, dp);
    }
}
