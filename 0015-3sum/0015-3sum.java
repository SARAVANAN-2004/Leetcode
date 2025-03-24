class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int n= nums.length;
        for(int k = 0;k<n-1;k++){
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = 0, j = n-1;
            int n1 = nums[k];
            while(i < j){
                if(i == k) i++;
                else if(j == k) j--;
                else{
                    int sum = nums[i]+nums[j]+n1;
                    if(sum == 0){
                        int max = Math.max(nums[i],Math.max(nums[j],n1));
                        int min = Math.max(nums[i],Math.min(nums[j],n1));
                        String key = min+" "+(sum - max-min)+" "+max;
                        if(!set.contains(key)){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        }
                        set.add(key);
                        i++;
                        j--;
                    }else if(sum < 0){
                        i++;
                    }else{
                        j--;
                    }
                }
            }
        }
        return ans;

    }
}