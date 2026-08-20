class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        if(n==0) return 0;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        int ans = 1;
        
        for (int x : set) {
            int count = 0;
            if(!set.contains(x-1)){
                while(set.contains(x+count)){
                    count++;
                }
                if(count>ans) ans = count;
            }
        }
        return ans;
    }
}