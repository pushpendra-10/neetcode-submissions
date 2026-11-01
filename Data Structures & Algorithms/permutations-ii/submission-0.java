class Solution {
    List<List<Integer>> ans;
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void permutations(int idx, int[] nums){
        if(idx == nums.length){
            ArrayList temp = new ArrayList<>();
            for(int ele: nums){
                temp.add(ele);
            }
            ans.add(temp);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);

            swap(nums, i, idx);
            permutations(idx + 1, nums);
            swap(nums, i, idx);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        permutations(0, nums);

        return ans;
    }
}