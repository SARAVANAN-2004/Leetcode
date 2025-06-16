class Solution {
    public String predictPartyVictory(String senate) {
        int r  = 0 , d = 0;
        int  rval = 0 , dval = 0;
        Queue<Character> que = new LinkedList<>();
        for(char ch:senate.toCharArray()){
                que.add(ch);
                if(ch == 'R') r++;
                else d++;
        }
        while(r != 0 && d!=0){
            char ch = que.poll();


            if(ch == 'R'){
                if(rval > 0){
                    rval--;
                    continue;
                }
                dval++;
                d--;
            }else{
                if(dval > 0){
                    dval--;
                    continue;
                }
                rval++;
                r--;
            }
            que.add(ch);
        }

        return r == 0? "Dire":"Radiant";
    }
}