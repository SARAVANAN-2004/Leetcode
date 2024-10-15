class Solution {
    public long minimumSteps(String s) {
        char[] arr =s.toCharArray();
        int idx = arr.length-1;
        long cnt = 0;
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i] == '1'){
               cnt += (idx-i);
               idx--;
            }
        }
        return cnt;
    }
}