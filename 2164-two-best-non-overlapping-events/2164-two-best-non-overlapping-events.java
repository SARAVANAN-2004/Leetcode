class Solution {
    public int maxTwoEvents(int[][] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
        for(int i[]:arr){
            pq.offer(i);
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int max = 0;
        for(int i[]:arr){
            max = Math.max(max,solve(i,pq));
        }
        return max;

    }

    int solve(int[] arr,PriorityQueue<int[]> pq){
        int val = arr[2];
        int st = arr[0], en = arr[1];
        while(!pq.isEmpty() && pq.peek()[0] <= en){
            pq.poll();
        }
        if(pq.isEmpty()){
            return val;
        }

        return val+pq.peek()[2];
    }
}