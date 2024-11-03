class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length() != s.length()){
            return false;
        }
        StringBuilder str = new StringBuilder(s);
        str.append(s);
        s = str.toString();
        int n = goal.length();
        for(int i = 0;i<n;i++){
            if(goal.equals(s.substring(i,i+n))){
                return true;
            }
        }
        return false;
    }
}