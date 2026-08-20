class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;


            for(int j=i+1; j<n; j++){
                long t = (long)target-nums[i]-nums[j];
                if(j>i+1 && nums[j] == nums[j-1]) continue;


                int k = j+1, l=n-1;
                while(k<l){
                    long sum = (long)nums[k] + nums[l];
                    if(sum < t) k++;
                    else if(sum > t) l--;
                    else{
                        list.add(Arrays.asList(nums[i],nums[j],nums[k++],nums[l--]));
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && l<n-1 && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return list;
    }
}