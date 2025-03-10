class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int n = chars.length;
        for(int i = 0;i<n;i++){
            int cnt = 0;
            int j = i;
            while(j < n && chars[i] == chars[j]){
                cnt++;
                j++;
            }
            chars[idx++] = chars[i];
            if(cnt == 1) continue;
            else{
               for(char ch:(""+cnt).toCharArray()) chars[idx++] = ch;
               i = j-1;
            }
        }
        return idx;
    }
}