class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] grp = new int[n];
        for(int g = 0;g < n/2;g++){
            grp[g*2] = g;
            grp[g*2+1] = g;
        }
        int swap = 0;
        for(int i = 0;i<n;i+=2){
            int fid = row[i];
            int secid = row[i+1];
            if(fid != (secid^1)){
                if(grp[fid] != grp[secid]){
                    swap++;
                    union(grp,fid,secid);
                }
            }
        }
        return swap;
    }
    void union(int[] grp ,int fid,int secid){
        int grpFid = grp[fid];
        for(int i = 0;i<grp.length;i++){
            if(grp[i] == grpFid){
                grp[i] = grp[secid];
            }
        }
    }


}