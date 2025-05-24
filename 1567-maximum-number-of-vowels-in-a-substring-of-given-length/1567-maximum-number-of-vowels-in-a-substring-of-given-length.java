class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        for(char ch: "aeiou".toCharArray()){
            set.add(ch);
        }
        int maxi = 0;
        int cnt = 0;
        int i = 0;
        while(i <s.length()){
            if(set.contains(s.charAt(i))){
                cnt++;
            }
            if(i < k){
               
            }else{
                if(set.contains(s.charAt(i-k))){
                    cnt--;
                }
            }
            maxi = Math.max(maxi,cnt);
            i++;
        }
        return maxi;
    }

}