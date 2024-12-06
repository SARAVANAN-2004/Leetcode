class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int i:banned){
            set.add(i);
        }
        int sum = 0;
        int cnt = 0;
        for(int i = 1;i<=n && sum <= maxSum;i++){
            if(sum > maxSum){
                return cnt;
            }
            if(!set.contains(i)){
                System.out.println(i);
            
            sum+=i;
            if(sum > maxSum){
                return cnt;
            }
            cnt++;
            }
        }
        return cnt;
    }
}