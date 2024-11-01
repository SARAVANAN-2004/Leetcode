class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        for(char ch:s.toCharArray()){
            if(i == 0 || i == 1){
                str.append(ch);
                i++;
            }else if(ch != str.charAt(i-1) || str.charAt(i-1) != str.charAt(i-2)){
                str.append(ch);
                i++;
            }
        }
        return str.toString();
    }
}