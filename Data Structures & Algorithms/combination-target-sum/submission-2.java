class Solution {
    // only see first solution
    
    List<List<Integer>> ans;

    public void solve(int i, List<Integer> list, int[] arr, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if (i == arr.length) {
            return;
        }

        int j = i+1;
        while(j<arr.length && arr[j] == arr[i]){
            j++;
        }
        solve(j , list, arr, target);

        if (arr[i] <= target) {
            list.add(arr[i]);
            solve(i, list, arr, target - arr[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(0, list, candidates, target);

        return ans;
    }
}