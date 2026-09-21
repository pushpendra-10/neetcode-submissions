class Solution {
    public int solve(int[] nums, int idx, int xor){
        if(idx == nums.length) return xor;

        int skip = solve(nums, idx+1, xor);
        int take = solve(nums, idx+1, xor^nums[idx]);

        return skip + take;
    }

    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

}