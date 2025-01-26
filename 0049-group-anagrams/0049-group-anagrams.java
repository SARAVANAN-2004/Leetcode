class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer> map = new HashMap<>();
        List<List<String>>  res = new ArrayList<>();
        for(String str :strs){
            String s = sort(str);
            if(!map.containsKey(s)){
                map.put(s,res.size());
                res.add(new ArrayList<>());
            }
            int i = map.get(s);
            res.get(i).add(str);
        
        }
        return res;
    }

    public static String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}