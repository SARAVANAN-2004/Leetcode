class Solution {
    public long minEnd(int n, int x) {
        long res = 0;
        long bit;
        n--;
        int[] binx = new int[64];
        int[] binn = new int[64];
        long lx = x,ln = n;

        for(int i = 0;i<64;++i){
            bit = (lx >> i) & 1;
            binx[i] = (int)bit;
            bit = (ln >> i) & 1;
            binn[i] = (int)bit;

        }
        int posx = 0,posn = 0;
        while(posx < 64){
            while(binx[posx] != 0 && posx< 64){
                posx++;
            }
            binx[posx] = binn[posn];
            
            posx++;
            posn++;

        }
        // System.out.println(Arrays.toString(binx));
        // System.out.println(Arrays.toString(binn));

        for(int i = 0;i<64;i++){
            if(binx[i] == 1){
                res += Math.pow(2,i);
            }
        }

        return res;

    }
}