class Solution {
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        solve(ans,temp,nums,n,0);
        int max = 0;
        int cnt = 0;
        for(int i :nums){
            max = max | i;
        }

        for(List<Integer> arr: ans){
            if(valid(arr,max,n)){
                cnt++;
            }
        }
        return cnt;
        
    }
    public static void solve(List<List<Integer>> ans,List<Integer> temp,int[] nums,int n,int st ){
        if(st == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[st]);
        solve(ans,temp,nums,n,st+1);
        
        temp.remove(temp.size()-1);
        solve(ans,temp,nums,n,st+1);  

    }

    public static boolean valid(List<Integer> arr,int max,int n){
        if(arr.size() == n){ return true;}
        int curmax = 0;
        for(int i:arr){
            curmax |= i;
        }

        return curmax == max;
    }
}