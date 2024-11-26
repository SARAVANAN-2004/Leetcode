class Solution {
    class worker{
        int q;
        double wqr;

        public worker(int q,double wqr){
            this.q = q;
            this.wqr = wqr;
        }

    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<worker> arr = new ArrayList<>();
        int n = wage.length;
        for(int i = 0;i<n;i++){
            arr.add(new worker(quality[i],((double)wage[i] / quality[i])));
        }
        Collections.sort(arr,(a,b)->Double.compare(a.wqr,b.wqr));
        double minCost = Double.MAX_VALUE;
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(worker w:arr){
            total += w.q;
            pq.add(w.q);

            if(pq.size() == k){
                double curCost = total*w.wqr;
                total -= pq.poll();
                minCost  = Math.min(curCost,minCost);
            }
        }

        return minCost;
    }
}