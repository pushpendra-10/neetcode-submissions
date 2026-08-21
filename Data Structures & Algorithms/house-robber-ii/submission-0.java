class Solution { // memoization
    public int money(int i, int n, int[] nums, int[] dp) {
        if(i > n) return 0;

        if(dp[i] != -1) return dp[i];

        int skip = money(i+1, n, nums, dp);
        int take = nums[i] + money(i+2, n, nums, dp);
        
        return dp[i] = Math.max(skip, take);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(money(0, n-2, nums, dp1), money(1, n-1, nums, dp2));
    }
}
