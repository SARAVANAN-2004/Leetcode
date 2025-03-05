class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            if(sum == k) cnt++;

            if(map.containsKey(sum-k)){
                cnt += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return cnt;
    }
}