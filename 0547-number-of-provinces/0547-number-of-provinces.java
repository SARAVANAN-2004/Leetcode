class Solution {
    boolean[] vis;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        vis = new boolean[n];
        int cnt = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                cnt++;
                process(isConnected,n,vis,i);
            }
        }
        return cnt;
    }

    void process(int[][] arr,int n ,boolean[] vis,int cur){
        vis[cur] = true;
        for(int i = 0;i<n;i++){
            if(arr[cur][i] == 1 && !vis[i]){
                process(arr,n,vis,i);
            }
        }
    }
}