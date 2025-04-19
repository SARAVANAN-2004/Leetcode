class Solution {
    Map<Integer,Integer> map;
    public int minSwapsCouples(int[] row) {
        map  = new HashMap<>();
        int n = row.length;
        // Read the elements into the array and store their indices in the map
        for (int i = 0; i < n; i++) {
            // row[i] = in.nextInt();
            map.put(row[i], i);
        }
         int swaps = 0;

        // Iterate through the array in steps of 2
        for (int i = 0; i < n; i += 2) {
            int first = row[i];
            
            // Determine the expected second element based on the first element
            int second = first + (first % 2 == 0 ? 1 : -1);
            
            // If the next element is not the expected second element, perform a swap
            if (row[i + 1] != second) {
                swaps++;
                swap(row, i + 1, map.get(second));
            }
        }
        return swaps;
    }
    public  void swap(int[] row, int i, int j) {
        int t = row[i];
        row[i] = row[j];
        row[j] = t;

        // Update the map with the new indices of the swapped elements
        map.put(row[i], i);
        map.put(row[j], j);
    }


}