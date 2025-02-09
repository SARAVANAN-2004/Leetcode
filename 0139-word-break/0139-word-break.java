class Solution {
    Set<String> set = new HashSet<>();
    Map<Integer,Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict){
            set.add(str);
        }
        return solve(s,0);
    }
    boolean solve(String s,int start){
        if(start == s.length()){
            return true;
        }
        if(memo.containsKey(start)){
            return memo.get(start);
        }
        for(int end = start+1;end <= s.length();end++){
            if(set.contains(s.substring(start,end))){ 
                if(solve(s,end)){
                    // memo.put(start,true);
                    return true;
                }
            }
        }
        memo.put(start,false);
        return false;
    }
}