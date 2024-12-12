class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts){
            pq.offer(i);
        }

        for(int i = 0;i<k;i++){
            int n = pq.poll();
            n = (int)(Math.floor(Math.sqrt(n)));
            pq.offer(n);
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}