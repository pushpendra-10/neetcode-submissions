class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.add(i);
        }

        int n = nums.length;
        int[] ans = new int[n-k+1];
        ans[0] = nums[dq.peekFirst()];
        for(int i=1; i<=n-k; i++){
            int j = i+k-1;
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]){
                dq.pollLast();
            }
            if(!dq.isEmpty() && dq.peekFirst() < i){
                dq.pollFirst();
            }
            dq.add(j);
            ans[i] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
