class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0) { return res;}
        int curWidth = 0,len = 0;
        for(String s:words){
            int curLen = s.length();
            if(curLen + curWidth > maxWidth){
                process(res,ans,curWidth,len,maxWidth);
                curWidth = 0;
                len = 0;
                ans.clear();
            }
            len += s.length();
            curWidth += s.length()+1;
            ans.add(s);
        }
        lastLine(res,ans,len,maxWidth);
        return res;
    }
    void lastLine(List<String> res,List<String> ans,int len,int maxWidth){
        StringBuilder temp = new StringBuilder();
        for(String s:ans){
            temp.append(s);
            if(temp.length() < maxWidth){
                temp.append(" ");
            }
        }
        while(temp.length() < maxWidth){
            temp.append(" ");
        }
        res.add(temp.toString());
    }

    void process(List<String> res,List<String> ans,int curWidth,int len,int maxWidth){
        StringBuilder temp = new StringBuilder();
        int space = ans.size() - 1;
        int extraSpace = maxWidth - len;
        int minSpace = extraSpace;
        int maxSpace = 0;
        if(space != 0){
            minSpace = extraSpace / space;
            maxSpace = extraSpace % space;
        }

        String spaces = "";
        for(int i = 0;i<minSpace;i++){
            spaces += " ";
        }
        for(String s:ans){
          
            temp.append(s);
            if(temp.length() < maxWidth){
                temp.append(spaces);
                if(maxSpace > 0){
                    temp.append(" ");
                    maxSpace--;
                }
            }
        }
     
        res.add(temp.toString());
    }
}