class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] arr = new int[n];
        Arrays.sort(potions);
        for(int i = 0;i<n;i++){
            arr[i] = solve(spells[i],potions,success);
        }
        return arr;
    }

    public int solve(int val,int[] arr,long suc){
        int l = 0, r= arr.length-1;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;
            long v = (long)arr[mid] * val;
            // System.out.println(arr[mid]+" "+val);
            // System.out.println(v);
            if( v >= suc){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res == -1?0:arr.length - res;
    }

}