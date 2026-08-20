class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int lo = 0;
        int hi = n-1;
        int L = 0;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid] == x){
                L = mid;
                break;
            }
            else if(arr[mid] < x){
                L = mid;
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        int R = L+1;

        while(k > 0 && L >= 0 && R < n){
            if(Math.abs(arr[L]-x) <= Math.abs(arr[R]-x)){
                L--;
            }
            else{
                R++;
            }
            k--;
        }
        while(k > 0 && L>=0){
            L--;
            k--;
        }
        while(k > 0 && R < n){
            R++;
            k--;
        }
        L++;
        R--;

        List<Integer> list = new ArrayList<>();
        while(L<=R){
            list.add(arr[L]);
            L++;
        }
        return list;
    }
}