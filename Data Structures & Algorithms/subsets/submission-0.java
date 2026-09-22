class Solution {
    List<List<Integer>> list;
    public void solve(int i, List<Integer> arr, int[] nums){
        if(i == nums.length){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<arr.size(); j++){
                temp.add(arr.get(j));
            }
            list.add(temp);
            return;
        }
        solve(i+1, arr, nums);
        arr.add(nums[i]);
        solve(i+1, arr, nums);
        arr.remove(arr.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        solve(0, new ArrayList<>(), nums);
        return list;
    }
}
