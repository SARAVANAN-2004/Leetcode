class Solution {
    public int splitArray(int[] nums, int k) {
        // Initialize low and high for binary search:
        // low is the maximum single element (minimum possible largest subarray sum)
        // high is the sum of all elements (maximum possible largest subarray sum)
        int low = nums[0];
        int high = nums[0];
        for (int i = 1; i < nums.length; i++) {
            low = Math.max(low, nums[i]); // max element
            high += nums[i];              // total sum
        }

        // Binary search for the minimum largest subarray sum
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // Get the number of subarrays needed if we limit max sum of any subarray to mid
            int cnt = numberOfSubarray(nums, mid);

            if (cnt > k) {
                // Too many subarrays -> mid is too small -> increase lower bound
                low = mid + 1;
            } else {
                // Can split into <= k subarrays -> try a smaller max sum
                high = mid - 1;
            }
        }

        // After the loop, 'low' is the minimal possible largest subarray sum
        return low;
    }

    // Helper function to determine how many subarrays are needed
    // if we limit the maximum subarray sum to 'max_val'
    int numberOfSubarray(int[] arr, int max_val) {
        int subarray = 1;     // Start with one subarray
        int cur_val = arr[0]; // Running sum of the current subarray

        for (int i = 1; i < arr.length; i++) {
            // If adding the current element doesn't exceed max_val, keep adding
            if (cur_val + arr[i] <= max_val) {
                cur_val += arr[i];
            } else {
                // Otherwise, start a new subarray
                subarray++;
                cur_val = arr[i];
            }
        }
        return subarray;
    }
}
