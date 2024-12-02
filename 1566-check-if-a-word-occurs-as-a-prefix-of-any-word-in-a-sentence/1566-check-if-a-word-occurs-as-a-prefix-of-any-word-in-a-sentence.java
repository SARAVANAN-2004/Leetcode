class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        int i = 1;
        for(String s:arr){
            if(s.length() >= searchWord.length() && searchWord.equals(s.substring(0,searchWord.length()))){
                return i;
            }
            i++;
        }

        return -1;
    }
}