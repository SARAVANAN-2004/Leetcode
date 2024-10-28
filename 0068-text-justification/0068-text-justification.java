class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int curwidth = 0;
        int len = 0;
        for(int i = 0;i<words.length;i++){
            String s = words[i];
            int curLen = s.length();
            if(curwidth+curLen>maxWidth){
                process(res,ans,maxWidth,curwidth,len);
                curwidth = 0;
                len = 0;
                ans.clear();
            }
            len += s.length();
            curwidth += s.length()+1;
            ans.add(s);
        }
        lastLine(res,ans,maxWidth,curwidth,len);
        return res;
        
    }
    void lastLine(List<String> res,List<String> ans,int maxWidth,int curwidth,int len){
        StringBuilder temp = new StringBuilder();
        for(String s:ans){
            temp.append(s);
            if(temp.length() <maxWidth){
                temp.append(" ");
            }
        }
        while(temp.length() < maxWidth){
            temp.append(" ");
        }
        res.add(temp.toString());
    }
    

    void process(List<String> res,List<String> ans,int maxWidth,int curwidth,int len){
        StringBuilder temp = new StringBuilder();
        int spaces = ans.size()-1;
        // System.out.println(ans);
        // System.out.println("max "+maxWidth+" curWidth "+ curwidth+" space "+spaces+"len "+len);
        int extraspace = maxWidth - len;
        int minspace = maxWidth - len;
        int maxspace  = 0;
        if(spaces != 0){
        minspace = extraspace/spaces;
        maxspace = extraspace%spaces;
        }
        // System.out.println("extra "+extraspace+" minspace "+minspace+" maxspace "+maxspace);

        String space = "";
        for(int i = 0;i<minspace;i++){
            space += " ";
        }

        for(int i = 0; i<ans.size();i++){
            temp.append(ans.get(i));
            if(temp.length() < maxWidth){
                temp.append(space);
                if(maxspace>0){
                    temp.append(" ");
                    maxspace--;
                }
            }
        }
        res.add(temp.toString());
        
    }
}