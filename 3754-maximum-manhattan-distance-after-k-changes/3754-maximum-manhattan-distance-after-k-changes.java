class Solution {
    public int maxDistance(String str, int k) {
        int n = 0, w = 0,s = 0, e = 0;
        int maxi = 0;
        for(char ch:str.toCharArray()){
            switch(ch){
                case 'N':
                    n++;
                    break;
                case 'W':
                    w++;
                    break;
                case 'S':
                    s++;
                    break;
                case 'E':
                    e++;
                    break;
            }
        
        // System.out.println(n+" "+s+" "+e+" "+w);
        int sum = Math.max(n,s) + Math.max(e,w);
        int r = Math.min(n,s) + Math.min(e,w);
        // System.out.println(ch+" "+sum+" "+r);
        int swap = Math.min(r,k);
        r -= swap;
        sum = sum -r +swap;
        maxi = Math.max(maxi,sum);
        }
        return maxi;
    }
}