class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");
        for(int i = 0;i<n-1;i++){
            // System.out.println(s);
            StringBuilder temp = invert(s);
            temp.reverse();
            s.append("1"+temp);
        }

        // System.out.println(s);
        
        return s.charAt(k-1);
    }

    public StringBuilder invert(StringBuilder s){
        StringBuilder word = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                word.append("0");
            }else{
                word.append("1");
            }
        }
        return word;
    }
}