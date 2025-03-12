class Solution {
    public void rotate(int[][] matrix) {
        trans(matrix);
        swap(matrix);
    }
    void trans(int[][] arr){
        int n = arr.length;
        int l = 0;
        while(l < n){
            for(int  i= l ;i<n;i++){
                int temp = arr[l][i];
                arr[l][i] = arr[i][l];
                arr[i][l] = temp;
            }
            l++;
        }
    }
    void swap(int[][] arr){
        int l = 0;
        int r = arr.length - 1;
        int n = arr.length;
        while(l < r){
            for(int i = 0;i<n;i++){
                int temp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = temp;
            }
            l++;
            r--;
        }
    }
}