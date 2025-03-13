class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] word = s.split("\\s+");
        StringBuilder r = new StringBuilder();
        for (int i = word.length -1 ; i>=0 ; i--){
            r.append(word[i]);
            if(i!=0){
                r.append(" ");
            }
        } 
        return r.toString();
    }
}