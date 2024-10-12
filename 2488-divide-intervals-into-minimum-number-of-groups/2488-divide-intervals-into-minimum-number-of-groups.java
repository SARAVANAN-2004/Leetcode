class Solution {
    public int minGroups(int[][] intervals) {
        int n  = intervals.length;
        List<int[]> arr = new ArrayList<>();
        for(int[] i : intervals){
            arr.add(new int[]{i[0],1});
            arr.add(new int[]{i[1],-1});
        }
        Collections.sort(arr,(a,b)->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int[] pre = new int[arr.size()];
        int sum = 0;
        int max =0;
        for(int i = 0;i<arr.size();i++){
            sum += arr.get(i)[1];
            pre[i] = sum;
            max = Math.max(sum,max);
        }
        System.out.println(Arrays.toString(pre));
        for(int[] i :arr){
            System.out.println(Arrays.toString(i));
        }
        return max;
    }
}