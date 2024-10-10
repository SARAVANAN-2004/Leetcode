class Solution {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> indicesStack = new Stack<>();

        // Fill the stack with indices in increasing order of their values
        for (int i = 0; i < n; i++) {
            if (indicesStack.isEmpty() || nums[indicesStack.peek()] > nums[i]) {
                indicesStack.push(i);
            }
        }

        int maxWidth = 0;

        // Traverse the array from the end to the start
        for (int j = n - 1; j >= 0; j--) {
            while (
                !indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[j]
            ) {
                maxWidth = Math.max(maxWidth, j - indicesStack.peek());
                // Pop the index since it's already processed
                indicesStack.pop();
            }
        }

        return maxWidth;
    }
}