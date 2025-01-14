class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        int n = A.length;
        int[] res = new int[n];
        int cnt = 0;
        for(int i = 0;i<n;i++){
            set1.add(A[i]);
            set2.add(B[i]);
            if(set2.contains(A[i])){
                cnt++;
            }
            if(A[i] != B[i] && set1.contains(B[i])){
                cnt++;
            }
            res[i] = cnt;
        }
        return res;

    }
}