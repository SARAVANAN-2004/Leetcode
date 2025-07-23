class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> map1 = new HashMap<>();
        // System.out.println(Arrays.toString(arr));

        if(arr.length != pattern.length()) return false;
        for(int  i = 0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if((map.containsKey(ch) && !map.get(ch).equals(arr[i])
            || (map1.containsKey(arr[i]) && ch != map1.get(arr[i])))){
                // System.out.println(ch+" "+map.get(ch));
                return false;
            }
            map.put(ch,arr[i]);
            map1.put(arr[i],ch);
        }
        return true;
    }
}