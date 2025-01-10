class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] cnt = new int[26];
        for(String s:words2){
            int[] cur = new int[26];
            for(char ch :s.toCharArray()){
                cur[ch-'a']++;
                cnt[ch-'a'] = Math.max(cur[ch-'a'],cnt[ch-'a']);
            }
        }

        List<String> res = new ArrayList<>();
        for(String s:words1){
            int[] arr = new int[26];
            for(char ch:s.toCharArray()){
                arr[ch-'a']++;
            }
            if(valid(arr,cnt)){
                res.add(s);
            }
        }

        return res;
    }

    public boolean valid(int[] arr,int[] cnt){
        for(int i = 0;i<26;i++){
            if(cnt[i] > arr[i]){
                return false;
            }
        }
        return true;
    }
}