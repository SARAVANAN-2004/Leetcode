class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int n= nums.length;
        for(int k = 0;k<n-1;k++){
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1, j = n-1;
            int n1 = nums[k];
            while(i < j){
                int sum = nums[i]+nums[j]+n1;
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    i++;
                    while(nums[i] == nums[i-1] && i < j) i++;
                    j--;
                    while(nums[j] == nums[j+1] && i < j) j--;
                }else if(sum < 0){
                    i++;
                }else{
                    j--;
                }
                
            }
        }
        return ans;

    }
}