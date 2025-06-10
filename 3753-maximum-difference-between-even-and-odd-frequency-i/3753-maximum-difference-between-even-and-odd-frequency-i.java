class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        int a1 = 1, a2 = Integer.MAX_VALUE;
        for(int i:arr){
            if(i%2 == 1){
                a1 = Math.max(a1,i);
            }else if(i != 0){
                a2 = Math.min(a2,i);
            }
        }
        // System.out.println(a2);
        return a1-a2;
    }
}