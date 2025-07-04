class Solution {
    char[] arr1, arr2,arr3;
    int x,y,z;
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        x = s1.length();
         y = s2.length();
          z = s3.length();
        if(x+y != z) return false;
        arr1  = s1.toCharArray();
        arr2 = s2.toCharArray();
        memo = new int[x+1][y+1];
        for(int []r:memo){
            Arrays.fill(r,-1);
        }
        arr3 = s3.toCharArray();
        return solve(0,0,0);
    }

    public boolean solve(int i,int j,int k){
        if(k == z){
            return true;
        }
        if(memo[i][j] != -1){
            return memo[i][j] == 0?false:true;
        }
        boolean res = false;
        if(i < x && j < y){
            char ch1 = arr1[i];
            char ch2 = arr2[j];
            char ch3 = arr3[k];
            if(ch1 == ch3 && ch2 == ch3){
                res =  solve(i+1,j,k+1) || solve(i,j+1,k+1);
            }else if(ch1 == ch3){
                 res =  solve(i+1,j,k+1);
            }else if(ch2 == ch3){
                res = solve(i,j+1,k+1);
            }else{
                res = false;
            }
        }else if(i < x){
            char ch1 = arr1[i];
            char ch3 = arr3[k];
            if(ch1 == ch3){
                 res =  solve(i+1,j,k+1);
            }else{
                res =  false;
            }
        }else{
            char ch2 = arr2[j];
            char ch3 = arr3[k];
            if(ch2 == ch3){
               res = solve(i,j+1,k+1);
            }else{
                res =  false;
            }
        }
        memo[i][j] = res?1:0;
        return res;
    }
}