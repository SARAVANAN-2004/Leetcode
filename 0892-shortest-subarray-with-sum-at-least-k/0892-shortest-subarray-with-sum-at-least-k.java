class Solution {
    public int shortestSubarray(int[] arr, int k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        int curidx = 0,n = arr.length;
        long sum = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            sum+=arr[i];

            if(sum >= k){
                len = Math.min(len,i+1);
            }

            while(!pq.isEmpty() && sum - pq.peek()[0] >= k){
                len = Math.min(len,(int)(i- pq.poll()[1]));
            }
            pq.offer(new long[]{sum,i});
        }
        return len == Integer.MAX_VALUE?-1:len;
        
    }
}