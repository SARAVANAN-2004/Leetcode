class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        // for(int []i:arr) System.out.println(Arrays.toString(i));
        
        int cnt = 0;
        int prev = arr[0][1];

        for(int i = 1;i<arr.length;i++){
            // System.out.println(arr[i][0] +" "+prev);
            if(arr[i][0] < prev){
                cnt++;
            }else{
                prev = arr[i][1];
            }
        }
        return cnt;
    }
}