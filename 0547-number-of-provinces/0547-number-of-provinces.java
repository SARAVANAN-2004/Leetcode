class Solution {
    public int findCircleNum(int[][] arr) {
        int  cnt = 0;
        int n = arr.length;
        boolean[] vis = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                cnt++;
                process(arr,n,vis,i);
            }
        }
        return cnt;
    }
    void process(int[][] arr,int n,boolean[] vis,int curRow){
        vis[curRow] = true;
        for(int i = 0;i<n;i++){
            if(arr[curRow][i] == 1 && !vis[i]){
                process(arr,n,vis,i);
            }
        }
    }
}