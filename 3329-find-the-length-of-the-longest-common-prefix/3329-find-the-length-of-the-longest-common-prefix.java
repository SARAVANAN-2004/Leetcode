class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:arr1){
            while(i > 0){
                set.add(i);  
                i /= 10;      
            }
        }
        int cnt = 0;
        for(int i:arr2){
            while(i > 0){
                    set2.add(i);
                i /= 10;
            }
        }
        System.out.println(set+""+set2);
        for(int i :set){
            if(set2.contains(i)){
                cnt  = Math.max(cnt,String.valueOf(i).length());
            }
        }
        return cnt;
    }
}