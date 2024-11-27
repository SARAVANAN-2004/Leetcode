class Solution {
    public int minFlips(int a, int b, int c) {
        int max = Math.max(a,Math.max(b,c));
        int shift = 0;
        int cnt = 0;
        while((1<< shift)<= max){
            int abit = (1 & (a >> shift));
            int bbit = (1 & (b >> shift));
            int cbit = (1 & (c >> shift));

            if((abit | bbit) == cbit){
                
            }else{
                if(cbit == 0){
                    if(abit==1 && bbit == 1){
                        cnt+=2;
                    }else{
                        cnt++;
                    }
                }
                if(cbit == 1){
                    cnt++;
                }
            }
            shift++;
        }
        return cnt;
    }
}