class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] indices = new int[n];
        int maxWidth = 0;

        // Step 1: Build an array of indices where nums[indices] are decreasing
        int indexSize = 0; // This will act like a stack pointer for our indices array
        for (int i = 0; i < n; i++) {
            if (indexSize == 0 || nums[indices[indexSize - 1]] > nums[i]) {
                indices[indexSize++] = i;
            }
        }

        // Step 2: Traverse from the end of the array and check for maximum ramp
        for (int i = n - 1; i >= 0; i--) {
            while (indexSize > 0 && nums[indices[indexSize - 1]] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - indices[--indexSize]);
            }
        }

        return maxWidth;
    }
}
