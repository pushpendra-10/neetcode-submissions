class Solution {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int j = 0;

        while (j < n) {
            if (nums[j] <= 0 || nums[j] > n) {
                j++;
                continue;
            }
            if (nums[j] == j + 1) {
                j++;
                continue;
            }
            if (nums[j] == nums[nums[j] - 1]) {
                j++;
                continue;
            }
            swap(nums, j, nums[j] - 1);
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}