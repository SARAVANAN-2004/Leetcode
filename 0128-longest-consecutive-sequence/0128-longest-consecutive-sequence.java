class obj{
    int cnt;
    boolean visited;
    public obj(int cnt,boolean visited){
        this.cnt = cnt;
        this.visited = visited;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Map<Integer,obj> map = new HashMap<>();
        for(int i:nums){
            map.put(i,new obj(0,false));
        }
        int ans = 0;
        for(int i:nums){
            
            dfs(map,i,i);
            
            ans = Math.max(ans,map.get(i).cnt);
        }
        return ans;
    }

    public void dfs(Map<Integer,obj> map,int num,int curnum){
        if(!map.containsKey(curnum) || map.get(curnum).visited){
            return;
        }
        map.get(num).cnt += 1;
        map.get(curnum).visited = true;
        dfs(map,num,curnum-1);
        dfs(map,num,curnum+1);

    }
}