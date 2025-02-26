class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        for(int r = row-2;r>=0;r--){
            for(int c = 0;c<triangle.get(r).size();c++){
                int x = triangle.get(r+1).get(c);
                int y = triangle.get(r+1).get(c+1);
                int z = triangle.get(r).get(c);
                triangle.get(r).set(c,Math.min(x,y)+z);
                
            }
        }
        return triangle.get(0).get(0);
    }
}