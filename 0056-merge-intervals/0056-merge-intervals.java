class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> arr = new ArrayList<>();
        int i = 0,n = intervals.length;
        while(i < n){
            int st = intervals[i][0];
            int end = intervals[i][1];
            i++;
            while(i < n){
                int st1 = intervals[i][0];
                int end1 = intervals[i][1];
                if(st1 <= end){
                    end = Math.max(end1,end);
                    i++;
                }else{
                    break;
                }
            }
            arr.add(new int[]{st,end});

        }
        int[][] ans = new int[arr.size()][2];
        for(int j = 0;j<arr.size();j++){
            ans[j][0] = arr.get(j)[0];
            ans[j][1] = arr.get(j)[1];
        }
        return ans;
    }
}