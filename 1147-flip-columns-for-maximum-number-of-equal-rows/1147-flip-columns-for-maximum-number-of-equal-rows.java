class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        Map<String,Integer> pattern = new HashMap<>();
        for(int[] curRow:matrix){
            StringBuilder builder = new StringBuilder("");
            for(int c = 0;c<curRow.length;c++){
                if(curRow[0] == curRow[c])
                {
                    builder.append("T");
                }else{
                    builder.append("F");
                }
            }
                String rowPattern = builder.toString();
                pattern.put(rowPattern,pattern.getOrDefault(rowPattern,0)+1);
            
        }
        int max = 0;
        for(int freq:pattern.values()){
            max = Math.max(freq,max);
        }
        return max;
    }
}