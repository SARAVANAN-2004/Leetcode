class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        int[] lps = generatelps(s+"-"+str.toString());
        // System.out.println(Arrays.toString(lps));
        return new StringBuilder(s.substring(lps[(2*s.length())])).reverse().toString() + s;
    }
    public int[] generatelps(String s){
        int[] lps = new int[s.length()];
        lps[0] = 0;
        int streakidx = 0;
        for(int i = 1;i<s.length();){
            if(s.charAt(i) == s.charAt(streakidx)){
                streakidx++;
                lps[i] = streakidx;
                i++;
            }else{
                if(streakidx == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    streakidx = lps[streakidx-1];
                }
            }
        }
        return lps;
    }
}