class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            pq.add(i);
        }
        for(int i = 0;i<k;i++){
            int n = pq.poll();
            sum += n;
            pq.add(ceil(n));

        }
        // System.out.println(ceil(2));
        return sum;
    } 
    public int ceil(int n){
        if(n%3 == 0){
            return n/3;
        }
        return (n/3)+1;
    }
}