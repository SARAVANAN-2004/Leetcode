class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        for(int i = 0;i<n;){
            int cnt = 0;
            char cur = word.charAt(i);
            
            while(i < n && cur == word.charAt(i) && cnt<9){
                cnt++;
                i++;
            }
            
            comp.append(""+cnt+cur);
            
        }
        return comp.toString();


    }
}