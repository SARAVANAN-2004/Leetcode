class Solution {
    public int minimumDeletions(String word, int k) {
        int[] arr = new int[26];
        int cnt = 0;
        for(char ch:word.toCharArray()){
            if(arr[ch-'a'] == 0){
                cnt++;
            }
            arr[ch-'a']++;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<26;i++){
            int ch = arr[i];
            if(ch == 0) continue;
            int cur = 0;
            for(int j = 0;j<26;j++){
                if(arr[j] == 0) continue;
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