class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        find(res,new ArrayList<Integer>(),nums);
        return res;
    }
     private void find(List<List<Integer>> res,List<Integer> temp,int[] nums){
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])){
                temp.add(nums[i]);

            find(res, temp, nums);
            temp.remove(temp.size()-1);}
        }
     }
}