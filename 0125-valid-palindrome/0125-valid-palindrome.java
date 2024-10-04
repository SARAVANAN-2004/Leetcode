class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int l = 0,r = s.length()-1;
        // System.out.println(s);
        return solve(s.trim().toLowerCase(),l,r);
    }
    public boolean solve(String s,int l,int r){
        if(l>=r){
            return true;
        }
        char ch1 = s.charAt(l);
        char ch2 = s.charAt(r);

        if((valid(ch1) && valid(ch2)) && (ch1 != ch2)){
            // System.out.println(ch1+" "+ch2);
            return false;
        }
        else if(!valid(ch1) && valid(ch2)){
            return solve(s,l+1,r);
        }else if(valid(ch1) && !valid(ch2)){
            return solve(s,l,r-1);
        }

        return solve(s,l+1,r-1);
        
        
    }

    boolean valid(char ch){
        if(((ch >= 'A' && ch <= 'Z')|| ( ch >= 'a' && ch <= 'z')) || Character.isDigit(ch) ){
            return true;
        }
        return false;
    }
}