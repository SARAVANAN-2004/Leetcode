class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberst = new Stack<>();
        Stack<StringBuilder> charst = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int number = 0;
        for(char c : s.toCharArray()){
         
          if(Character.isDigit(c)){
             number = number *10 + (c - '0');
          }else if(c == '['){
             numberst.add(number);
             charst.add(curr);
             curr = new StringBuilder();
             number = 0;
          }else if(c == ']'){
            int count = numberst.pop();
            StringBuilder temp = charst.pop();
            while(count-- > 0){
                temp.append(curr);
            }
            curr = temp;
          }else{
            curr.append(c);
          }
       
        }
        return curr.toString();
    }
}