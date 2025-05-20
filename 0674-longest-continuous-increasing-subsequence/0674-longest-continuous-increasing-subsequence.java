class Solution {
    public int findLengthOfLCIS(int[] num) {
        int m1 = 0 ,m2 = 0;
        if (num.length == 1){
            return 1;
        }
        for(int i = 0; i < num.length-1 ;i++){
            if (num[i] < num[i+1]){
                m2++;
            }
            else{
                m2 = 0;
            }
            m1 = Math.max(m1,m2);

        }
        return m1+1;
    }
}