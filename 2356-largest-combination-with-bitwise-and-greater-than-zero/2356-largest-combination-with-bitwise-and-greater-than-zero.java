class Solution {
    public int largestCombination(int[] candidates) {
        int[] arr = new int[24];
        for(int i :candidates){
            setBits(arr,i);
        }
        // System.out.println(Arrays.toString(arr));
        int max = 0;
        for(int i:arr){
            max = Math.max(i,max);
        }
        // System.out.println(candidates[0]&1);
        return max;
    }
    void setBits(int[] arr,int n){
        int i = 0;
        while(n > 0){
            
            if((n&1)!=0){
                arr[i]++;
        }
            n = n >> 1;
            i++;
        }
    }
}