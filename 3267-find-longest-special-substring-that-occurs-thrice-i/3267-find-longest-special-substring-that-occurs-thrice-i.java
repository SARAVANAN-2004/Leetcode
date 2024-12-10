class Solution {
    public int maximumLength(String s) {
        Map<String,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            StringBuilder str = new StringBuilder();
            for(int j = i;j>=0 && s.charAt(i) == s.charAt(j);j--){
                str.append(s.charAt(j));
                map.put(str.toString(),map.getOrDefault(str.toString(),0)+1);
            }
        }
        int maxLen = -1;
        for(String st:map.keySet()){
            int val = map.get(st);
            int len =st.length();
            if(val >= 3 && len >= maxLen){
                maxLen  = len;
            }
        }
        // System.out.println(map);
        return maxLen;
    }
}