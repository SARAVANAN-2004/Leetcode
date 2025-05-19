class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if(nums[2] >= nums[0]+nums[1]) return "none";
        Set<Integer> set = new HashSet<>();
        for(int i:nums) set.add(i);
        int n = set.size();
        
        return n == 3 ?"scalene":n==2?"isosceles":"equilateral";
        
    }
}