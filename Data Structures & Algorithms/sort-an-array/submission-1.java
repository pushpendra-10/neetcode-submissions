class Solution {
    public void merge(int[] arr, int lo, int mid, int hi){
        int[] p = new int[mid-lo+1];
        int[] q = new int[hi-mid];

        for(int i=0; i<p.length; i++) p[i] = arr[lo+i];
        for(int i=0; i<q.length; i++) q[i] = arr[mid+1+i];

        int i=0,j=0,k=lo;
        while(i<p.length && j<q.length){
            if(p[i] <= q[j]) arr[k++] = p[i++];
            else arr[k++] = q[j++];
        }
        while(i<p.length) arr[k++] = p[i++];
        while(j<q.length) arr[k++] = q[j++];
    }
    public void mergeSort(int[] arr, int lo, int hi){
        if(lo >= hi) return;
        int mid = lo + (hi-lo)/2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid+1, hi);

        merge(arr, lo, mid, hi);
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums,0,n-1);
        return nums;
    }
}