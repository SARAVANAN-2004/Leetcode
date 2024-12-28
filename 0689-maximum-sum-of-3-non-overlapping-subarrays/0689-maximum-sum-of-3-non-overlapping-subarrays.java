class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] ksum = new int[n - k + 1];
        int[] l = new int[n - k + 1];
        int[] r = new int[n - k + 1];

        int maxsum = 0;
        for (int i = 0; i < k; i++) {
            maxsum += nums[i];
        }
        ksum[0] = maxsum;

        for (int i = 1; i < n - k + 1; i++) {
            ksum[i] = ksum[i - 1] - nums[i - 1] + nums[i + k - 1];
        }

        maxsum = ksum[0];
        l[0] = 0;
        for (int i = 1; i < n - k + 1; i++) {
            if (ksum[i] > maxsum) {
                maxsum = ksum[i];
                l[i] = i;
            } else {
                l[i] = l[i - 1];
            }
        }

        maxsum = ksum[n - k];
        r[n - k] = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            if (ksum[i] >= maxsum) {
                maxsum = ksum[i];
                r[i] = i;
            } else {
                r[i] = r[i + 1];
            }
        }

        int[] ans = new int[3];
        int max = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int sum = ksum[l[i - k]] + ksum[i] + ksum[r[i + k]];
            if (sum > max) {
                max = sum;
                ans[0] = l[i - k];
                ans[1] = i;
                ans[2] = r[i + k];
            }
        }

        return ans;
    }
}
