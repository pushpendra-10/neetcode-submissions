class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for(int weight: weights){
            if(weight>lo) lo = weight;
            hi += weight;
        }
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            int daysUsed = 1;
            int sum = 0;
            for(int weight: weights){
                if(sum + weight > mid){
                    daysUsed++;
                    sum = 0;
                }
                sum += weight;
            }

            if(daysUsed <= days) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}