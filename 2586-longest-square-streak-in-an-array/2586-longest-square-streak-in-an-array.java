class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Long,Integer> map = new HashMap<>();
        int max = 0;
        for(int n:nums){
           map.put((long)(n*n),map.getOrDefault((long)(n),0)+1);
           max = Math.max(max,map.get((long)(n*n)));
        }
        
        return max==1?-1:max;


    }
}