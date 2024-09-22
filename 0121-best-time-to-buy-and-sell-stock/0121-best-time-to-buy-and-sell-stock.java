class Solution {
    public int maxProfit(int[] arr) {
        int diff = 0;
        int min = arr[0];
        for(int i = 1;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            diff = Math.max(diff,arr[i]-min);
        }
        return diff;
    }
}