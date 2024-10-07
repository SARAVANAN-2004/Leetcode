class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        helper(n,res,temp,0,0);
        return res;
    }

    void helper(int n,List<String> res,StringBuilder temp,int opcnt,int clcnt){
        if(temp.length() == n*2){
            res.add(temp.toString());
            return;
        }
        if(opcnt<n){
            temp.append("(");
            helper(n,res,temp,opcnt+1,clcnt);
            temp.deleteCharAt(temp.length()-1);
        }
        if(clcnt<n && opcnt>clcnt){
            temp.append(")");
            helper(n,res,temp,opcnt,clcnt+1);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}