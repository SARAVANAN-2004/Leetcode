import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, target, 0, memo);
    }

    int dfs(int[] arr, int sum, int target, int idx, Map<String, Integer> memo) {
        if (idx == arr.length) {
            return sum == target ? 1 : 0;
        }

        String key = idx + "," + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = dfs(arr, sum + arr[idx], target, idx + 1, memo);
        int subtract = dfs(arr, sum - arr[idx], target, idx + 1, memo);

        memo.put(key, add + subtract);

        return add + subtract;
    }
}
