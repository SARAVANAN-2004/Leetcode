class Solution {
    public double maxAverageRatio(int[][] classes, int extra) {
         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare((a[0] / (double) a[1]) - (a[0] + 1) / (double) (a[1] + 1), (b[0] / (double) b[1]) - (b[0] + 1) / (double) (b[1] + 1)));

        for(int i[]:classes){
            pq.add(i);
        }
         for(int i = 0;i<extra;i++){
            int[] cur = pq.poll();
            cur[0]++;
            cur[1]++;
            pq.add(cur);
         }
         double val  = 0;
         while(!pq.isEmpty()){
            int[] cur = pq.poll();
            val += (cur[0]/(double)cur[1]);
         }
         return val/(double)classes.length;
    }
}