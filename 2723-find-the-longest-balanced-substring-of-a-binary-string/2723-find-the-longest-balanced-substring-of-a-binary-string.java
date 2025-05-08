class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        char[] arr = s.toCharArray();
        int z = 0, o = 0,n = arr.length, i = 0;
        int maxi = 0;
        while(i < n){
            if(arr[i] == '0'){
                while(i < n && arr[i] == '0'){
                    z++;
                    i++;
                }
            }else{
                while(i < n && arr[i] == '1'){
                    o++;
                    i++;
                }
                if(z != 0){
                    int min = Math.min(z,o);
                    maxi = Math.max(min*2,maxi);
                    
                }
                z = 0;
                o = 0;
            }
        }
        return maxi;
    }
}