class Solution {
    public void sub(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        int j = idx+1;
        while(j<nums.length && nums[j] == nums[j-1]){
            j++;
        }

        sub(j, nums, list, ans);
        list.add(nums[idx]);
        sub(idx+1, nums, list, ans);
        list.remove(list.size()-1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        sub(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}