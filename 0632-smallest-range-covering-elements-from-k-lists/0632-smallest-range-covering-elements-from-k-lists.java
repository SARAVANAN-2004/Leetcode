class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> interval = new ArrayList<>();
        int[] ans = new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b [0]);
        int max = Integer.MIN_VALUE;
        int[] idx = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[] {nums.get(i).get(0), i});
            max = Math.max(nums.get(i).get(0), max);
        }

        while(true){
            int[] curval = pq.poll();
            int minval = curval[0];
            int lstidx = curval[1];

            interval.add(new int[]{minval,max});
            idx[lstidx]++;

            if(idx[lstidx] >= nums.get(lstidx).size()){
                break;
            }
            int nextval = nums.get(lstidx).get(idx[lstidx]);

            pq.add(new int[]{nextval,lstidx});
            max = Math.max(max,nextval);
        }
        interval.sort((a,b)->{
            if(a[1] - a[0] == b[1] - b[0]){
                return a[0] - b[0];
            }else{
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });
        
        // for(int[] i:interval){
        //     System.out.println(Arrays.toString(i));
        // }
        return interval.get(0);

    }
}