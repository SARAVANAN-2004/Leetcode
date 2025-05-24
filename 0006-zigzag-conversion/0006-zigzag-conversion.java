class Solution {
    public String convert(String s, int row) {
        StringBuilder[] arr = new StringBuilder[row];
        for(int i = 0;i<row;i++){
            arr[i] = new StringBuilder();
        }
        int i = -1;
        int op = 1;
        if(row == 1) return s;
         for(char ch :s.toCharArray()){
            i+=op;
            if(i == row){
                i-=2;
                op = -1;
            }else if(i == -1){
                i+=2;
                op = 1;
            }
            
            arr[i].append(ch);
        }
       StringBuilder sb = new StringBuilder();
       for(i = 0;i<row;i++){
            sb.append(arr[i]);
        }
       return sb.toString();
    }
}