class Solution {
    public int minGroups(int[][] intervals) {
        int n  = intervals.length;
        int rst = Integer.MIN_VALUE;
        int rend = 0;
        for(int[] i : intervals){
            rst = Math.min(i[0],rst);
            rend = Math.max(rend,i[1]);
        }
        
        int[] arr =new int[rend+2];
        for(int[] i :intervals){
            arr[i[0]]++;
            arr[i[1] +1]--;
        }
        int sum = 0;
        int max =0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            max = Math.max(sum,max);
        }
        // System.out.println(Arrays.toString(arr));
    
        return max;
    }
}