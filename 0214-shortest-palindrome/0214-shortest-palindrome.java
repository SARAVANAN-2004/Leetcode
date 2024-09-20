class Solution {
    public String shortestPalindrome(String s) {
        String revstr = new StringBuilder(s).reverse().toString();
        String pattern = s + "*"+  revstr;
        int[] lps = kmpalgo(pattern);
        // System.out.println(Arrays.toString(lps));
        int n = lps[pattern.length()-1];
        return new StringBuilder(s.substring(n)).reverse().toString()+s;
    }

    public int[] kmpalgo(String pattern){
        int[] lps = new int[pattern.length()];
        int i = 0;
        int j = 1;
        while(j < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i != 0){
                    i = lps[i-1];
                }else{
                    lps[j] = i;
                    j++;
                }
            }
        }
        return lps;
    }
}