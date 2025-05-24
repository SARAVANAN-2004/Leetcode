class Solution {
    public String convert(String s, int row) {
        List<List<Character>> arr = new ArrayList<>();
        for(int i = 0;i<row;i++){
            arr.add(new ArrayList<>());
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
            // System.out.println(i+" ");
            arr.get(i).add(ch);
        }
       StringBuilder sb = new StringBuilder();
       for(List<Character> a:arr){
        for(char ch:a) sb.append(ch);
       }
       return sb.toString();
    }
}