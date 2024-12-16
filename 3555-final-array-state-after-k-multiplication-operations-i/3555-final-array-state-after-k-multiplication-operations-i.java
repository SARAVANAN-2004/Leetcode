class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new  PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        for(int i = 0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});
        }

        for(int i = 0;i<k;i++){
            int[] cur = pq.poll();
            cur[0] *= multiplier;
            pq.add(cur);
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            nums[cur[1]] = cur[0];
        }
        return nums;

    }
}