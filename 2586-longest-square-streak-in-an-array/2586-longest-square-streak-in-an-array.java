class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[100001];
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int n:nums){
            int root = (int)Math.sqrt(n);
            if(root*root != n){
                arr[n] = 1;
            }else{
           arr[n] = arr[root]+1;
            }
           max = Math.max(max,arr[n]);
        }
        // System.out.println(map);
        return max==1?-1:max;


    }
}