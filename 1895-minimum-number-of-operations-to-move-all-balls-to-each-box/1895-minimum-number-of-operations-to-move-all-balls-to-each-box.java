class Solution {
    public int[] minOperations(String boxes) {
        char[] arr = boxes.toCharArray();
        int n = arr.length;
        int[] ans = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            if(arr[i] == '1'){
                set.add(i);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j : set){
                if(i != j){
                    ans[i] += Math.abs(i-j);
                }
            }
        }
        return ans;

    }
} 

