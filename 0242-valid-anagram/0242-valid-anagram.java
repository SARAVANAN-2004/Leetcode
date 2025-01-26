class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] arr = new int[26];
        for(char a:s.toCharArray()){
            arr[a-'a']++;
        }for(char a:t.toCharArray()){
            arr[a-'a']--;
        }

        for(int i:arr){
            if(i != 0) return false;
        }
        return true;
    }
}