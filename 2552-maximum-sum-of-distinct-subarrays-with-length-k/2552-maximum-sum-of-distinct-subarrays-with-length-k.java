import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0, n = nums.length;

        for (int r = 0; r < n; r++) {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            sum += nums[r];

            while (freq.size() < r - l + 1 || r - l + 1 > k) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0) {
                    freq.remove(nums[l]);
                }
                sum -= nums[l];
                l++;
            }

            if (freq.size() == k && r - l + 1 == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}
