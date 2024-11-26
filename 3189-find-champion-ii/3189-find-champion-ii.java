class Solution {
    public int findChampion(int n, int[][] edges) {
        int [] arr = new int[n];
        for(int a[]:edges ){
            arr[a[1]]++;
        }
        System.out.println(Arrays.toString(arr));
        int cnt = 0;
        int idx = 0;
        for(int i = 0;i<n;i++){
            if(arr[i] == 0){
                cnt++;
                idx = i;
            }
        }
        return cnt==1?idx:-1;
    }
}