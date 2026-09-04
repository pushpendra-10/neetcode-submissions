class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currmax = 1;
        int currmin = 1;
        for(int ele: nums){
            int temp = currmax*ele;
            currmax = Math.max(temp, Math.max(currmin*ele, ele));
            currmin = Math.min(temp, Math.min(currmin*ele, ele));

            res = Math.max(res, currmax);
        }
        return res;
    }
}