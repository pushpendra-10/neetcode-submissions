class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int count = 0;
        int pref_s = 0;
        map.put(0,1);
        for(int ele: nums){
            pref_s += ele;
            if(!map.containsKey(pref_s - k)){
                map.put(pref_s-k,0);
            }
            else{
                count += map.get(pref_s-k);
            }
            map.put(pref_s, map.getOrDefault(pref_s,0)+1);
        }
        return count;
    }
}