class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> number = new HashMap<>();
        number.put('2',"abc");
        number.put('3',"def");
        number.put('4',"ghi");
        number.put('5',"jkl");
        number.put('6',"mno");
        number.put('7',"pqrs");
        number.put('8',"tuv");
        number.put('9',"wxyz");
        String[] arr = new String[digits.length()];
        int i = 0;
        for(char ch:digits.toCharArray()){
            arr[i++] = number.get(ch);
        }
        if(arr.length == 0) return res;
        solve(arr,new StringBuilder(),0,arr.length);
        return res;
    }

    void solve(String[] arr, StringBuilder temp,int i,int n){
        if(i == n){
            res.add(temp.toString());
            return;
        }
        String s = arr[i];
        for(char ch:s.toCharArray()){
            temp.append(ch);
            solve(arr,temp,i+1,n);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}