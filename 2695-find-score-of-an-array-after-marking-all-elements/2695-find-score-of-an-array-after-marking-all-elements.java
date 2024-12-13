class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        long score = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0;i<n;i++){
            pq.offer(new int[]{nums[i],i});
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int num = cur[0];
            int i = cur[1];
            if(vis[i]){
                continue;
            }else{
                score+=num;
                vis[i] =true;
                if(i-1 >= 0){
                    vis[i-1] =true;
                } 

                if(i+1<n){
                    vis[i+1] = true;
                }
            }
        }
        return score;
    }
}