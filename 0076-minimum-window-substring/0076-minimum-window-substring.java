class Solution {
    public String minWindow(String s, String t) {
        int[] ascii = new int[128];
        for(char ch:t.toCharArray()){
            ascii[ch]++;
        }
        int cnt  = t.length(), st = 0,minst = 0,minLen = Integer.MAX_VALUE;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ascii[ch] > 0){
                cnt--;
            }
            ascii[ch]--;
            while(cnt == 0){
                if(minLen > i - st+1){
                    minLen = i - st+1;
                    minst = st;
                }
                char f = s.charAt(st);
                ascii[f]++;
                if(ascii[f] > 0){
                    cnt++;

                }
                st++;
            }
        }

        return minLen == Integer.MAX_VALUE? "":s.substring(minst,minst+minLen);
    }
}