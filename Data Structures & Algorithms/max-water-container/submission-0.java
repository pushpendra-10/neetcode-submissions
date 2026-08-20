class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0,j=n-1;
        int max = 0;
        while(i<j){
            int cap = 0;
            if(height[i]<=height[j]){
                cap = (j-i)*height[i];
                i++;
            } 
            else{
                cap = (j-i)*height[j];
                j--;
            } 
            max = Math.max(cap,max);
        }
        return max;
    }
}