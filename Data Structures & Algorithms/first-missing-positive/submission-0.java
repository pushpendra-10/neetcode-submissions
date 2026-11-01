// O(n) time complexity
// O(n) space complexity
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int max = 0;
        int min = 1;
        HashSet<Integer>map = new HashSet<>();
        for(int i=0; i<n; i++){
            if(nums[i] > max && nums[i] > 0) max = nums[i];
            if(nums[i] < min && nums[i] > 0) min = nums[i];
            map.add(nums[i]);
        }
        if(min > 1) return 1; 
        for(int i=min; i<max; i++){
            if(!map.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}