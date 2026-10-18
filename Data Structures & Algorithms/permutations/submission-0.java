class Solution {

    List<List<Integer>> ans;

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void permutations(int idx, int[] nums){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<nums.length; j++){
                temp.add(nums[j]);
            }
            ans.add(temp);
        }
        for(int i=idx; i<nums.length; i++){
            swap(nums, idx, i);
            permutations(idx+1, nums);
            swap(nums, idx, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        permutations(0, nums);
        return ans;
    }
}
