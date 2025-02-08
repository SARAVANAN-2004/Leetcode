class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }else{
                return a[0] - b[0];
            }
        }
        );
        for(int i[]:points){
        System.out.print(Arrays.toString(i)+" ");
        }
        int arrow = 0;
        int i = 0;
        int n = points.length;
        while(i < n){
            int st = points[i][0];
            int en = points[i][1];
            i++;
            arrow++;
            
            while(i < n){
                int st1 = points[i][0];
                int en1 = points[i][1];
                if(st1 >= st && st1<=en){
                    st = Math.max(st1,st);
                    en = Math.min(en1,en);
                    i++;
                }else{
                    break;
                }
            }
        }
        return arrow;
    }
}