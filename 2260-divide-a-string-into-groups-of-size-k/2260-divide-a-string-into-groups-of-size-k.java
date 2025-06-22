class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] arr = new String[(int)Math.ceil((double)n/k)];
        for(int i = 0;i<n;i+=k){
            String str = s.substring(i,Math.min(n,i+k));
            while(str.length() < k){
                str += fill;
            }
            arr[i/k] = str;
        }
        return arr;
    }
}