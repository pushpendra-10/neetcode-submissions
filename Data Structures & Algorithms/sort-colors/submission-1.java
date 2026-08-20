class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];  // 0,1,2
        
        for(int x: nums){
            bucket[x]++;
        }

        int j=0;
        for(int i=0; i<3; i++){
            while(bucket[i] > 0){
                nums[j] = i;
                j++;
                bucket[i]--;
            }
        }
    }
}