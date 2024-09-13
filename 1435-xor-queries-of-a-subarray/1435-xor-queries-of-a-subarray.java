class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] q:queries){
            int ans = arr[q[0]];
            for(int i = q[0]+1;i<=q[1];i++){
                    ans ^= arr[i];
            }
            res[idx++] = ans;
        }
        return res;
    }
}