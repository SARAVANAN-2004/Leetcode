class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int n:nums){
            int root = (int)Math.sqrt(n);
            if(root*root != n){
                map.put(n,1);
            }else{
           map.put(n,map.getOrDefault(root,0)+1);
            }
           max = Math.max(max,map.get(n));
        }
        // System.out.println(map);
        return max==1?-1:max;


    }
}