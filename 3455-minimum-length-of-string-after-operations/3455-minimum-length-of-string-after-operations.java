class Solution {
    public int minimumLength(String s) {
        char[] str = s.toCharArray();
        int[] right = new int[26];
        int n = str.length;
        for(int i = 1;i<n;i++){
            right[str[i] - 'a']++;
        }
        int[] left = new int[26];
        left[str[0] - 'a']++;
        int len = n;
        for(int i = 1;i<n-1;i++){
            right[str[i] - 'a']--;
            if(right[str[i] - 'a'] > 0 && left[str[i] - 'a'] > 0){
                len-=2;
                right[str[i] - 'a']--;
            }else{
                left[str[i] - 'a']++;
            }
        }
        return len;
    }
}