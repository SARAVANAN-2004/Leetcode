class Solution {
    public int findPeakElement(int[] arr) {
        int st =0;
        int en = arr.length-1;
        while(st!=en){
            int mid = (st+en)/2;
            if(arr[mid]>arr[mid+1]){
                en = mid;
                
            }else{           
                st = mid+1;
            }
        }
        return st;
    }
}
    
