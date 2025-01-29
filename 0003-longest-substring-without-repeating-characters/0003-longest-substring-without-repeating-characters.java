class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int l = 0;
        for(int i = 0;i<n;i++){
            if(set.contains(s.charAt(i))){
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(l++));

                }
            }
            set.add(s.charAt(i));
            max = Math.max(max,set.size());
        }
        return max;
    }
}