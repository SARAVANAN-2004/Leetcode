class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> result = new ArrayList<>();
        if(exp.length() == 0) return result;

        if(exp.length() == 1){
            result.add(Integer.valueOf(exp));
            return result;
        }
        if (exp.length() == 2 && Character.isDigit(exp.charAt(0))) {
            result.add(Integer.parseInt(exp));
            return result;
        }

        for(int i = 0;i<exp.length();i++){
            char curr = exp.charAt(i);
            if(Character.isDigit(curr)){
                continue;
            }
            List<Integer> leftres = diffWaysToCompute(exp.substring(0,i));
            List<Integer> rightres = diffWaysToCompute(exp.substring(i+1));

            for(int left:leftres){
                for(int right:rightres){
                    int computedres = 0;
                    switch(curr){
                        case '+':
                            computedres = left + right;
                            break;
                        case '-':
                            computedres = left - right;
                            break;
                        case '*':
                            computedres = left * right;
                            break;  
                    }
                    result.add(computedres);
                }
            }
        }
        return result;
    }
}