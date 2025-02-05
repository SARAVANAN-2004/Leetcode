class Solution {
    public String simplifyPath(String path) {
        StringBuilder str = new StringBuilder();
        String[] arr = path.split("/+");
        Stack<String> stack = new Stack<>();
        for(String s:arr){
            if(s.equals("..") && !stack.isEmpty()){
                stack.pop();
                if(!stack.isEmpty()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push("/");
                }
            }else if(s.equals(".")){
                continue;
            }else{
                
                stack.push(s);
                stack.push("/");
            }
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(stack);

        Stack<String> st = new Stack<>();
        while(!stack.isEmpty()){
            st.push(stack.pop());
        }
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        if(str.length() == 1 || str.length() == 0) return "/";
        return str.deleteCharAt(str.length()-1).toString();
    }
}