class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> set = new HashMap<>();
        for(int[] r:grid){
            set.put(Arrays.toString(r),set.getOrDefault(Arrays.toString(r),0)+1);
        }
        int cnt = 0;
        int n = grid.length;
        for(int r= 0;r<n;r++){
            for(int c = r;c<n;c++){
                int t = grid[r][c];
                grid[r][c] = grid[c][r];
                grid[c][r]= t;
            }
        }
        for(int []r:grid){
            if(set.containsKey(Arrays.toString(r))){
                cnt += set.get(Arrays.toString(r));
            }
        }

        return cnt;
    }
}