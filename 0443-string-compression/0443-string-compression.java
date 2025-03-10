class Solution {
    public int compress(char[] chars) {
        if(chars == null) return 0;
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
                String num = Integer.toString(cnt);
               for(int k = 0;k<num.length();k++) chars[idx++] = num.charAt(k);
               i = j-1;
            }
        }
        return idx;
    }
}