class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        List<Character> arr = new ArrayList<>();
        for(char ch:allowed.toCharArray()){
            arr.add(ch);
        }
        System.out.println(arr);
        int cnt = 0;
        for(String s:words){
            if(isvalid(arr,s)){
                System.out.println(s);
                cnt++;
            }
        }
        return cnt;
        
    }
    public boolean isvalid(List<Character> arr,String s){
        for(char ch:s.toCharArray()){
            if(!arr.contains(ch)){
                return false;
            }
        }
        return true;
    }
}