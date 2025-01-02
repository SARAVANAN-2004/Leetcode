class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[] prefix = new int[words.length];
        int sum = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(int i = 0;i<words.length;i++){
            String word = words[i];
            if(set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1))){
                sum++;
            } 
            prefix[i] = sum;
        }
        System.out.println(Arrays.toString(prefix));
        for(int i = 0;i<queries.length;i++){
            ans[i] = prefix[queries[i][1]];
            if(queries[i][0]-1 >= 0){
                ans[i] -= prefix[queries[i][0]-1];
            }
        }
        return ans;
    }
}