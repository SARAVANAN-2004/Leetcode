class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
    List<List<Integer>> res = new ArrayList<>();
  
        Arrays.sort(candidates);
        find(res, new ArrayList<Integer>(),candidates,target,0);
        return res;
    }

    void find(List<List<Integer>> res, List<Integer> temp, int[] nums, int target,int st) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
           
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = st; i <nums.length; i++) {
            if (i > st && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            temp.add(nums[i]);
            find(res, temp, nums,target - nums[i],i+1);
            temp.remove(temp.size() - 1);

        }
}
}