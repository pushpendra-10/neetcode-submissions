class Solution {
    List<List<Integer>> ans;
    public void solve(int idx, List<Integer> list, int[] arr, int k){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx; i<arr.length; i++){
            if(i>arr.length-(k-list.size()))
            {
                break;
            }
            {
            list.add(arr[i]);
            solve(i+1, list, arr, k);
            list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        solve(0, new ArrayList<>(), arr, k);
        return ans;
    }
}