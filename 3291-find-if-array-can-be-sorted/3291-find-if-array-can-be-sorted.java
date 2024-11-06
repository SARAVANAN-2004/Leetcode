class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = setBits(Integer.toBinaryString(nums[i]));
        }
        // System.out.println(Arrays.toString(arr));
        
        
        int prevMax = 0;
        for(int i = 0;i<n;){
            int curBit = arr[i];
            int curMax = nums[i];
            int curMin = nums[i];
            while(i< n && arr[i] == curBit){
                curMax = Math.max(nums[i],curMax);
                curMin = Math.min(nums[i],curMin);
                i++;
            }
            // System.out.println(curBit+" "+curMax+" "+curMin+" "+prevMax);
            if(prevMax > curMin){
                return false;
            }
            prevMax = curMax;
        }


        return true;
    }
    int setBits(String s){
        int cnt = 0;
        for(char ch:s.toCharArray()){
            if(ch == '1'){
                cnt++;
            }
        }
        return cnt;
    }
}