class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int x = nums[0];
        int y = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            int skip = y;
            int take = x + nums[i];
            
            x = y;
            y = Math.max(skip, take);
        }
        return y;
    }
}
