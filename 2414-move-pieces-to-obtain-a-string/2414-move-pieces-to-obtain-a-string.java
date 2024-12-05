class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        char[] st = start.toCharArray();
        char[] en = target.toCharArray();
        int stidx = 0,enidx = 0;
        while(stidx < n || enidx < n ){
            while(stidx < n && st[stidx] == '_' ){
                stidx++;
            }
            while(enidx < n && en[enidx] == '_'){
                enidx++;
            }

            if(stidx == n || enidx == n){
                return stidx == n && enidx == n;
            }
            if(st[stidx] != en[enidx] || (st[stidx] == 'L'  && stidx < enidx) 
            || (st[stidx] == 'R' && stidx > enidx)){
                return false;
            }
            stidx++;
            enidx++;
    }
        return stidx == n && enidx == n;
        
    }
}