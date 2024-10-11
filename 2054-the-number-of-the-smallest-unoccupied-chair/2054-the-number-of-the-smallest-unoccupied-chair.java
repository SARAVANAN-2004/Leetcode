class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int target = times[targetFriend][0];
        Map<Integer,List<Integer>> endTime = new HashMap<>();
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for(int i = 0;i<times.length;i++){
            availableChairs.add(i);
        }
        Arrays.sort(times,(a,b) ->{
            return a[0] - b[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->  a[0]-b[0]);

        for(int[] time:times){
            int arrive = time[0];
            int leave = time[1];
            while(!pq.isEmpty() && pq.peek()[0] <= arrive){
                availableChairs.add(pq.poll()[1]);
            }
            int assingedChair = availableChairs.poll();
            if(arrive == target) return assingedChair;

            pq.add(new int[]{leave,assingedChair});
            
        }
        
        

        return -1;
    }
}