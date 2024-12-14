class Solution {
    public long continuousSubarrays(int[] nums) {
        int l = 0,r = 0;
        long cnt = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b)->nums[a]-nums[b]);
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->nums[b]-nums[a]);

        while(r<nums.length){
            min.add(r);
            max.add(r);
         
            while(l<r && nums[max.peek()] - nums[min.peek()]>2){
                l++;
                while(!max.isEmpty() && max.peek() < l){
                    max.poll();
                }while(!min.isEmpty() && min.peek() < l){
                    min.poll();
                }
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}