class Solution {
   public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int cnt = 0;
        int mod = 1000000007;
        int n = nums.length;

        int[] powers = new int[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * 2) % mod;
        }

        for (int i = 0; i < n; i++) {
            int j = binarySearch(nums, i, n - 1, target - nums[i]);
            if (j >= i) {
                cnt = (cnt + powers[j - i]) % mod;
            }
        }

        return cnt;
    }

    public int binarySearch(int[] nums, int left, int right, int maxVal) {
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= maxVal) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}