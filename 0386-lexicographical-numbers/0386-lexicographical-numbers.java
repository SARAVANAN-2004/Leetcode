class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i<=9;i++){
            generate(ans,i,n);
        }
        return ans;
    }
    void generate(List<Integer> ans,int curr,int limit){
        if(curr > limit){
            return;
        }
        ans.add(curr);
        for(int i = 0;i<=9;i++){
            int newCurr = (curr*10)+i;
            if(newCurr <= limit){
            generate(ans,newCurr,limit);
            }else{
                break;
            }
        }
    }
}