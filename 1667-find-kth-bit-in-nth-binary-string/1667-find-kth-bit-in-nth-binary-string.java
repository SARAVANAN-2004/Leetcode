class Solution {
    public char findKthBit(int n, int k) {
        if(n==1||k==1)
        {
            return '0';
        }
        StringBuilder s = new StringBuilder("0");
        for(int i = 0;i<n-1;i++){
            // System.out.println(s);
            StringBuilder temp = invert(s);
            
            s.append("1"+temp);
        }

        // System.out.println(s);
        
        return s.charAt(k-1);
    }

    public StringBuilder invert(StringBuilder s){
        StringBuilder word = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                word.append("0");
            }else{
                word.append("1");
            }
        }
        return word;
    }
}