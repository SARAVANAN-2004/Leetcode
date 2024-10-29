class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        String lastword = "";
        for(int i = 0;i<folder.length;i++){
            
                if(ans.isEmpty() || isSubFolder(lastword.split("/"),folder[i].split("/"))){
                    ans.add(folder[i]);
                    lastword = folder[i];
                }
            
           }
        
        return ans;
    }

    boolean isSubFolder(String[] s1,String[] s2){

        for(int i =0;i<s1.length;i++){
            if(!s1[i].equals(s2[i])){
                return true;
            }
        }
        return false;
    }
}