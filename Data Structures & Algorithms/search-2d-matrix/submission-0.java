class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int lo=0;
        int hi=m*n-1;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            int row = mid/n;
            int col = mid%n;
            int ele = matrix[row][col];
            if(ele == target) return true;
            else if(ele<target) lo = mid+1;
            else hi = mid-1;
        }
        return false;
    }
}