class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0]; 
            }
        });
        // for(int []i:arr) System.out.println(Arrays.toString(i));
        int cnt = 0;
        int[] prev = arr[0];
        for(int i = 1;i<arr.length;i++){
           if(arr[i][0] >= prev[1]){
                prev = arr[i];
           }else{
                cnt++;
                if(arr[i][1] < prev[1]){
                    prev = arr[i];
                }
           }
        }
        return cnt;
    }
}