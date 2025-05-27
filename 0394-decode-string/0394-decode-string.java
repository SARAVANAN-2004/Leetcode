class Solution {
    class obj{
        int n = 0;
        String s = "";
        boolean num,bracket;
        
        public obj(int n,String s,boolean num,boolean bracket){
            this.n = n;
            this.s = s;
            this.bracket = bracket;
            this.num = num;
        }
    }
    public String decodeString(String s) {
        Stack<obj> stk = new Stack<>();
        
        
        for(char ch: s.toCharArray()){
           if(stk.isEmpty() || ch != ']'){
                
                if(Character.isDigit(ch)){
                    int n = Integer.valueOf(ch-'0');
                    
                    if(!stk.isEmpty() && stk.peek().num){
                        stk.peek().n = stk.peek().n * 10+n;
                    }else{
                        stk.push(new obj(n,"",true,false));
                    }
                }
                else if(ch == '['){
                    stk.push(new obj(0,"[",false,true));
                }else{
                    if(!stk.isEmpty() && !stk.peek().num  &&  !stk.peek().bracket){
                        stk.peek().s += ch;
                    }else{
                        stk.push(new obj(0,ch+"",false,false));
                    }
                }

           }else{
                String a = stk.pop().s;
                stk.pop();
                int n = stk.pop().n;
                StringBuilder sb = new StringBuilder();
                for(int i = 0;i<n;i++){
                    sb.append(a);
                }
                if(!stk.isEmpty() && !stk.peek().num  &&  !stk.peek().bracket){
                    stk.peek().s += sb.toString();
                }else{
                    stk.push(new obj(0,sb.toString(),false,false));
                }

           }
        }
        // for(obj o:stk){
        //     System.out.println(o.n+" "+o.s+" "+o.num+" "+o.bracket);
        // }
        return stk.peek().s;
    }
}