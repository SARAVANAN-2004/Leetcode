class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        
        int[] arr = Arrays.copyOf(nums,n);
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(nums));
        arr = Arrays.copyOfRange(arr,n-k,n);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] ans = new int[k];
        int i = 0;
        int j = 0;
        while(j < k){
            if(map.containsKey(nums[i])){
                // System.out.println(nums[i]);
                ans[j++] =nums[i];
                map.put(nums[i],map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
            }
            i++;
        }
        return ans;
    }
}