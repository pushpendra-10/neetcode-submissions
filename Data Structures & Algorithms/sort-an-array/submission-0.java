class Solution {
    public void merge(int[] arr, int lo, int mid, int hi){
        int n1 = mid-lo+1;
        int n2 = hi-mid;

        int[] p = new int[n1];
        int[] q = new int[n2];

        for(int i=0; i<n1; i++) p[i] = arr[i+lo];
        for(int i=0; i<n2; i++) q[i] = arr[i+mid+1];

        int i=0,j=0,k=lo;
        while(i<n1 && j<n2){
            if(p[i] <= q[j]) arr[k++] = p[i++];
            else arr[k++] = q[j++];
        }
        while(i<n1) arr[k++] = p[i++];
        while(j<n2) arr[k++] = q[j++];
    }

    public void mergeSort(int[] arr,int lo, int hi){
        if(lo<hi){
            int mid = lo + (hi-lo)/2;
            mergeSort(arr,lo,mid);
            mergeSort(arr,mid+1,hi);

            merge(arr,lo,mid,hi);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}