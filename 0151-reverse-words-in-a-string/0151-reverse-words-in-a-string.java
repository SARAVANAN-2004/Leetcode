class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i = words.length-1;i>=0;i--){
            // if(words.equals("")) continue;
            res.append(words[i]+" ");
        }
        
        return res.toString().trim();
    }
}