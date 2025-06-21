class Solution {
    public int minimumDeletions(String word, int k) {
        int[] map = new int[26];
        int cnt = 0;
        for(char ch:word.toCharArray()){
            if(map[ch-'a'] == 0){
                cnt++;
            }
            map[ch-'a']++;
        }
        int[] arr = new int[cnt];
        int i = 0;
        for(int j = 0;j<26;j++){
            if(map[j] > 0){
                arr[i++] = map[j];
            }
        }
      
        int min = Integer.MAX_VALUE;
        for(i = 0;i<cnt;i++){
            
            int ch = arr[i];
            if(ch == 0) continue;
            int cur = 0;
            for(int j = 0;j<cnt;j++){
                if(i == j){
                    continue;
                }else{
                   if(arr[j] < ch){
                        cur += arr[j];
                   }else if(arr[j] > ch + k){
                        cur += arr[j] - ch - k;
                   }
                }
            }
            min = Math.min(min,cur);
        }
        return min;
        
    }


}