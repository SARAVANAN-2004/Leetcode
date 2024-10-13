class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> arr = new ArrayList<>();
        if(nums.length == 0){return  arr;}
        if(nums.length == 1){
            arr.add(nums[0]+"");
            return  arr;}
        int l = 0;
        int r = 1;
        while( r <nums.length){
            if(nums[r]-1 != nums[r-1]){
                if(l != r-1){
                    arr.add(nums[l]+"->"+nums[r-1]);
                }else{
                    arr.add(nums[l]+"");
                }
                l = r;
            }
            r++;
        }
        if(l != r-1){
            arr.add(nums[l]+"->"+nums[r-1]);
        }else{
            arr.add(nums[l]+"");
        }
        return arr;
        
    }
}