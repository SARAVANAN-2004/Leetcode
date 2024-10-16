class obj{
    int cnt;
    char word;
    public obj(int cnt,char word){
        this.cnt = cnt;
        this.word = word;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<obj> pq = new PriorityQueue<>((x,y) -> y.cnt - x.cnt);
        pq.add(new obj(a,'a'));
        pq.add(new obj(b,'b'));
        pq.add(new obj(c,'c'));
        StringBuilder str = new StringBuilder();
        while(true){
            obj curr = pq.poll();
            obj next = pq.poll();
            boolean valid = false;
            if(str.isEmpty() || (str.charAt(str.length()-1) != curr.word)){
                valid = solve(str,curr,next,pq);
            }else{
                valid = solve(str,next,curr,pq);
            }
            if(valid){
            pq.add(curr);
            pq.add(next);
            }else{
                return str.toString();
            }

        }
    }

    public boolean solve(StringBuilder str,obj curr,obj next, PriorityQueue<obj> pq){
        if(curr.cnt <= 0){
            return false;
        }
        for(int i = 0;i< 2 && curr.cnt > 0;i++){
            str.append(curr.word);
            curr.cnt--;
        }
        if(next.cnt <= 0){
            return true;
        }
        if(next.cnt >= curr.cnt){
            str.append(next.word);
            next.cnt--;
        }
        if(next.cnt <= 0){
            return true;
        }
        str.append(next.word);
        next.cnt--;
        
        return true;
    }
}