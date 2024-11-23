class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for(int row = 0;row<m;row++){
            int r = n-1;
            for(int l = n-1;l>=0;l--){
                if(box[row][l] == '*'){
                    r = l-1;
                }else{
                    if(box[row][l] == '#' ){
                        char temp = box[row][l];
                        box[row][l] = box[row][r];
                        box[row][r--] = temp;
                    }
                }
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                ans[j][i] = box[i][j];
            }
        }
        // for(char arr[]:ans){
        //     System.out.println(Arrays.toString(arr));
        // }
        int l = 0,r = m-1;
        while(l<r){
            swap(ans,l,r,n);
            System.out.println(l+" "+r);
            l++;
            r--;
        }
        

        return ans;
    }

    void swap(char[][] arr,int l,int r,int n){
        for(int i = 0;i<n;i++){
            char temp = arr[i][l];
            arr[i][l] = arr[i][r];
            arr[i][r] = temp;
        }
    }
}