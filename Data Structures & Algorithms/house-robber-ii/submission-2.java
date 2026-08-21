class Solution { // tabulation
    public int money(int idx, int end, int[] nums) {
        int[] dp = new int[nums.length];
        dp[idx] = nums[idx];
        dp[idx+1] = Math.max(nums[idx], nums[idx+1]);
        for(int i=idx+2; i<=end; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[end];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        return Math.max(money(0, n-2, nums), money(1, n-1, nums));
    }
}
