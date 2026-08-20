class Solution {

    public long hours_required(int mid,int[] piles){
        long hours = 0;
        for(int pile : piles){
            hours += (pile + mid - 1) / mid;
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int lo = 1;
        int hi = 0;

        for(int pile : piles){
            hi = Math.max(hi,pile);
        }

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(hours_required(mid,piles) <= h) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}