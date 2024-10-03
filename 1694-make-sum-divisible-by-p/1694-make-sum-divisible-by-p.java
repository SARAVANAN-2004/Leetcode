class Solution {
    public int minSubarray(int[] arr, int p) {
        int  total = 0;
        for(int i:arr){
            total =(total+i)%p;
        
        }
        
        if(total %p == 0){
            return 0;
        }
        int rem = total%p;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int cursum = 0;
        int cnt = n;
        for(int i = 0;i <n;i++){
            cursum = (cursum+arr[i])%p;
            int need = (cursum - rem + p)%p;
            if(map.containsKey(need)){
                cnt = Math.min(cnt, i - map.get(need));
            }
            map.put(cursum,i);
        }

        return cnt != n ? cnt:-1;


    }
}