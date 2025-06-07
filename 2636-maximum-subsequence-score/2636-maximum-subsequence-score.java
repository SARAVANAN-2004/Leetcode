class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            arr.add(new int[]{nums1[i],nums2[i]});
        }
        Collections.sort(arr,(a,b)->{
            return b[1] - a[1];
        });
        long sum = 0;
        long maxi = 0;
        int min = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<nums1.length;i++){
            sum += arr.get(i)[0];
            min = arr.get(i)[1];
            pq.add(arr.get(i)[0]);
            // System.out.println(sum+" "+min);
            if(pq.size() == k){
                maxi = Math.max(maxi,sum*min);
                sum -= pq.poll();
            }
        }
        return maxi;
    }
}