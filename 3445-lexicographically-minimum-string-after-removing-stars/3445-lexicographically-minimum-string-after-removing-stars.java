class Solution {
    class Obj{
        int i;
        char ch;
        public Obj(char ch,int i){
            this.ch = ch;
            this.i = i;
        }
    }
    public String clearStars(String s) {
        
        PriorityQueue<Obj> pq = new PriorityQueue<>((a,b)->{
            if(a.ch == b.ch){
                return b.i - a.i;
            }else{
                return (int)(a.ch-b.ch);
            }
        });
        char[] arr = s.toCharArray();
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == '*'){
                if(!pq.isEmpty()){
                    arr[pq.poll().i] = '*';
                }
            }else{
                pq.add(new Obj(arr[i],i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:arr){
            if(ch != '*'){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}