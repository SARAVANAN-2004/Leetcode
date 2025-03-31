class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        
        // Step 1: Fill the count array using a traditional for loop
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                count[n]++; // Count citations greater than or equal to n
            } else {
                count[citations[i]]++;
            }
        }
        System.out.println(Arrays.toString(count));
        
        // Step 2: Calculate the h-index
        int totalPapers = 0;
        for (int i = n; i >= 0; i--) {
            totalPapers += count[i];
            if (totalPapers >= i) {
                return i; // Return h-index
            }
        }
        
        return 0; // In case no valid h-index is found
    }
}