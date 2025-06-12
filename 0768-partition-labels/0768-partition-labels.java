class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            map[ch-'a'] = i;
        }
        int st = 0;
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            max = Math.max(max,map[ch-'a']);
            if(max == i){
                res.add(max - st +1);
                st = i+1;
            }
        }
        return res;
    }
}