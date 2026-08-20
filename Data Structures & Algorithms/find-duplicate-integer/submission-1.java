class Solution {
    public int findDuplicate(int[] nums) {
        // int[] arr = new int[nums.length+1];
        // for(int ele: nums){
        //     if(arr[ele] == 1){
        //         return ele;
        //     }
        //     arr[ele]++;
        // }
        // return -1;

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; 
    }
}
