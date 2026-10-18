class Solution {
    public void sub(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));

        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i] == nums[i-1]){
                continue;
            }

            list.add(nums[i]);
            sub(i+1, nums, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        sub(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}