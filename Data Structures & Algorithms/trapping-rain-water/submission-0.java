class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        pref[0] = 0;
        suff[n-1] = 0;
        for(int i=1; i<n; i++){
            pref[i] = Math.max(height[i-1],pref[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            suff[i] = Math.max(height[i+1], suff[i+1]);
        }
        int sum = 0;
        int i=1;
        while(i<n-1){
            if(height[i] < pref[i] && height[i] < suff[i]){
                sum += Math.min(pref[i],suff[i]) - height[i];
            }
            i++;
        }
        return sum;
    }
}
