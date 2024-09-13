class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String,String> number = new HashMap<>();
        number.put("2","abc");
        number.put("3","def");
        number.put("4","ghi");
        number.put("5","jkl");
        number.put("6","mno");
        number.put("7","pqrs");
        number.put("8","tuv");
        number.put("9","wxyz");
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }
        StringBuilder temp = new StringBuilder();
        helper(digits,number,res,temp,0);
        return res;
    }
    void helper(String digits,HashMap<String,String> number,List<String> res,StringBuilder temp,int curidx){
        if(temp.length() == digits.length()){
            res.add(temp.toString());
            return;
        }
        String word = number.get(digits.charAt(curidx)+"");
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            temp.append(ch);
            helper(digits,number,res,temp,curidx+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}