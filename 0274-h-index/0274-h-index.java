class Solution {
    public int hIndex(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        int h = n-1,l = 0;
        while(l <= h){
            int mid = (h+l)/2;
            
            if(num[mid] == n - mid){
                return num[mid];
            }else if(num[mid] > n-mid){
                h = mid-1;
                
            }else{
                l = mid+1;
            }
        }
        return n-l;
    }
}