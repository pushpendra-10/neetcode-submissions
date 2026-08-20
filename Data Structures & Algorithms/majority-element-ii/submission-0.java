class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i], map.get(nums[i])+1);
            }
            if(map.get(nums[i])>n/3){
                set.add(nums[i]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        return list;
    }
}