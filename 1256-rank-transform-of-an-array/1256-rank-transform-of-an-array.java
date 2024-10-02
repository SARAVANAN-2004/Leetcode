class Solution {

    public int[] arrayRankTransform(int[] arr) {
        // Store the rank for each number in arr
        HashMap<Integer, Integer> numToRank = new HashMap<>();
        // Deduplicate and sort arr
        TreeSet<Integer> nums = new TreeSet<>();
        for (int num : arr) nums.add(num);
        int rank = 1;
        for (int num : nums) {
            numToRank.put(num, rank);
            rank++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numToRank.get(arr[i]);
        }
        return arr;
    }
}