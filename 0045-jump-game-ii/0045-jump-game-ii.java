class Solution {
    public int jump(int[] arr) {
        int jump = 1, step = arr[0], maxIdx = arr[0];

        if(arr.length == 1) return 0;
        for(int i = 1;i<arr.length;i++){
            step--;
            maxIdx = Math.max(maxIdx,i+arr[i]);
            if(step == 0 && i != arr.length-1){
                jump++;
                step = maxIdx - i;
            }
        }
        return jump;
    }
}