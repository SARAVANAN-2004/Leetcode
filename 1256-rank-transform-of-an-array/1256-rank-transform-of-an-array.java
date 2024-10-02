class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] num = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        // Copy the original array to num
        for (int i = 0; i < n; i++) {
            num[i] = arr[i];
        }

        // Sort the num array
        Arrays.sort(num);
        int rank = 1;

        // Assign ranks to the elements in num
        for (int i : num) {
            if (!map.containsKey(i)) {
                map.put(i, rank++);
            }
        }

        // Replace elements in the original array with their ranks
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}