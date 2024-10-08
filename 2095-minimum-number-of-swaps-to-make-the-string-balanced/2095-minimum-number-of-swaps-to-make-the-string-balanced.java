class Solution {
    public int minSwaps(String s) {

        int ocnt =0 ,cnct = 0;
        // Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch == '[' ){
                ocnt++;
            }
            else if (ch == ']' && ocnt != 0){
                ocnt--;
            }else{
                cnct++;
            }
            
        }

        return ((cnct)+1)/2;
    }
}