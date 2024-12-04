class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j = 0;
        for(int i = 0;i<str1.length() && j < str2.length();i++){
            char ch1 =  str1.charAt(i);
            char ch2 = str2.charAt(j);
            if(ch1 == ch2 || (ch1 == 'z' && ch2 == 'a') || (ch1+1== (int)(ch2))){
                j++;
            }

        }
        if(j == str2.length()){
            return true;
        }
        return false;
    }
}