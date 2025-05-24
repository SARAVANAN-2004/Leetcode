class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] arr = s.toCharArray();

        int maxi = 0;
        int cnt = 0;
        int i = 0;
        while(i <s.length()){
            if(set.contains(arr[i])){
                cnt++;
            }
            if(i < k){
               
            }else{
                if(set.contains(arr[i-k])){
                    cnt--;
                }
            }
            maxi = Math.max(maxi,cnt);
            i++;
        }
        return maxi;
    }

}