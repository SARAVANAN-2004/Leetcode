class Solution {
    public boolean canArrange(int[] num, int k) {
        
        int[] arr = new int[k];
        for(int i : num){
            int remainder = (i % k + k) % k; 
            arr[remainder]++;
        }
        // System.out.println(map);
        for(int n = 0; n < k-1;n++){

            if(n == 0){
                if(arr[n] % 2 != 0){
                    return false;
                }
            }
            else{
                if(n != k-n && arr[n] != arr[k-n]){
                    return false;
                }
            }
        }
        
        return true;
    }
}