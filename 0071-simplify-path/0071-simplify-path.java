class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] splits = path.split("/");
        for(String split: splits) {
            if(split.equals(".")) {
                continue;
            } else if(split.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(split.length() == 0) {
                continue;
            } else {
                stack.push(split);
            }

        }

        StringBuilder sb = new StringBuilder();
        for(String dir: stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() > 0 ? sb.toString(): "/";
    }
}

