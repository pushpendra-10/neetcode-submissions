class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] bucket = new List[n+1];

        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;
        for(int i=n; i>=0 && idx<k; i--){
            if(bucket[i] != null){
                for(int ele: bucket[i]){
                    ans[idx++] = ele;
                    if(idx == k) break;
                }
            }
        }
        return ans;
    }
}
