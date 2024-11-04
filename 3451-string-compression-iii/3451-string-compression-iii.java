class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        for(int i = 0;i<n;i++){
            int cnt = 0;
            char cur = word.charAt(i);
            int j = i;
            while(j < n && cur == word.charAt(j) && cnt<9){
                cnt++;
                j++;
            }
            i = j-1;
            comp.append(""+cnt+cur);
            
        }
        return comp.toString();


    }
}