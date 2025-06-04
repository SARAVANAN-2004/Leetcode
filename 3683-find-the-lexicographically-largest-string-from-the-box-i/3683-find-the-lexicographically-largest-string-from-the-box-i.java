class Solution {
    public String answerString(String word, int numFriends) {
        List<String> ans = new ArrayList<>();
        if(numFriends == 1) return word;
        int k = word.length() - numFriends +1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<k;i++){
            sb.append(word.charAt(i));
            ans.add(sb.toString());
        }
        int i = 0;
        int j = k;
        while(j <= word.length()){
            ans.add(word.substring(i,j));
            i++;
            j++;
        }
        while(i <= word.length()){
            ans.add(word.substring(i++,word.length()));
        }

        Collections.sort(ans);
        return ans.get(ans.size()-1);
    }
}