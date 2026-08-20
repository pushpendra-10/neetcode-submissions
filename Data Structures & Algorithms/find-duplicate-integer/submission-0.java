class Solution {
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length+1];
        for(int ele: nums){
            if(arr[ele] == 1){
                return ele;
            }
            arr[ele]++;
        }
        return -1;
    }
}
