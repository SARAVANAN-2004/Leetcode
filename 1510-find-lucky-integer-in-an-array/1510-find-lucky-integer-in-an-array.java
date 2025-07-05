class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int maxi = 0;
        for(int i :arr){
            maxi = Math.max(maxi,i);
        }
        int[] map = new int[maxi+1];
        for(int i :arr){
            map[i]++;
        }
        int ans = -1;
        for(int i = 1;i<=maxi;i++){
            if(map[i] == i){
                ans  = i;
            }
        }
        return ans;
        
    }
}