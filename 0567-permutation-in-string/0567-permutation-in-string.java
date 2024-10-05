class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int l = s1.length();
        int[] arr1 = new int[26];
        fill(arr1,s1);
    
        for(int i = 0;i< s2.length()-l+1;i++){
            int[] arr2 = new int[26];
            fill(arr2,s2.substring(i,i+l));
            if(valid(arr1,arr2,s1)){
                return true;
            }
        }
        return false;
    }
    boolean valid(int[] arr1,int[] arr2,String s){
        for(char ch:s.toCharArray()){
            if(arr1[ch-'a'] != arr2[ch-'a']){
                return false;
            }
        }
        return true;
    }

    void fill(int[] arr,String s){
        for(char ch:s.toCharArray()){
            arr[ch-'a'] += 1;
        }
    }
    
}