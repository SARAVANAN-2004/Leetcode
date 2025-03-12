class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int cnt = 0;
        for(int i = 0;i<arr.length;i++){
            if((i-1 < 0 || arr[i-1] == 0) && (i+1 >= arr.length || arr[i+1] ==0 ) && arr[i] == 0){
                cnt++;
                arr[i] = 1;
            }
        }
        // System.out.println(cnt);
        return  n<=cnt;
    }
}