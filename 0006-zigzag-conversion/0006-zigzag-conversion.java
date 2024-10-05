class Solution {
    public String convert(String s, int row) {
        List<List<Integer>> arr = new ArrayList<>();
        if(row > s.length() || row == 1){
            return s;
        }
        for(int i = 0;i<row;i++){
            arr.add(new ArrayList<>());
        }

        StringBuilder ans = new StringBuilder();
        fill(arr,row,s.length());
        for(int i = 0;i<row;i++){
            for(int j :arr.get(i)){
                ans.append(s.charAt(j));
            }
        }
        return ans.toString();
    }
    public static void fill(List<List<Integer>> arr,int row,int n){
        int rdir = 1;
        int r = -1;
        for(int i = 0;i<n;i++){
            r += rdir;
            if(r>=row-1){
                rdir = -1;     
            }
            if( r <= 0){
                rdir = 1;
            }
           arr.get(r).add(i);
        }
    }
}