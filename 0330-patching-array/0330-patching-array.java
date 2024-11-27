class Solution {
    public int minPatches(int[] arr, int n) {
        int  patchCtr = 0;
        long till = 0;
        for(int i = 0;till < n && i<arr.length;i++){
            if(till > arr[i]-1){
                till += arr[i];
            }else{
                while(till < n && till < arr[i]-1){
                    till += (till+1);
                    patchCtr++;
                }
                till += arr[i];
            }
        }

        while(till < n){
            till+=(till+1);
            patchCtr++;
        }

        return patchCtr++;
    }
}