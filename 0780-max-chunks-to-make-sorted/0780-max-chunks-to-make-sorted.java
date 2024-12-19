class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n  = arr.length;
        int[] val = new int[n];
        int[] pre = new int[n];
        int sum = 0;
        int cnt = 0;
        for(int i = 0;i<n;i++){
            val[i] = i*(i+1)/2;
            sum+=arr[i];
            pre[i] = sum;
            if(val[i] == pre[i]){
                cnt++;
            }
        }
        // System.out.println(Arrays.to?ing(pre));
        return cnt;
    }
}