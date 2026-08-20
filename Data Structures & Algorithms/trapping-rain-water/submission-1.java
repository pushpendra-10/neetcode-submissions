class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l=0, r=n-1;
        int lmax = 0, rmax = 0;
        int sum = 0;
        while(l<r){
            if(height[l] <= height[r]){
                if(height[l] < lmax){
                    sum += lmax-height[l];
                }
                else{
                    lmax = height[l];
                }
                l++;
            }
            else{ // height[r] < height[l] 
                if(height[r] < rmax){
                    sum += rmax-height[r];
                }
                else{
                    rmax = height[r];
                }
                r--;
            }
        }
        return sum;
    }
}
