class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int cnt = 0;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(isvalid(words[i],words[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean isvalid(String str1,String str2){
        int n = str1.length(), m = str2.length();
        if(m<n) return false;
        return str1.equals(str2.substring(0,n)) && str1.equals(str2.substring(m-n));
    }

}