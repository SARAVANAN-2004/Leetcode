class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIdx = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == key){
                for(int j = Math.max(i-k,0);j<Math.min(nums.length,i+k+1);j++){
                    if(!set.contains(j)){
                        ans.add(j);
                        set.add(j);
                    }
                }
            }
        }
        return ans;
    }
}