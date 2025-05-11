class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 1;i<arr.length-1;i++){
            if(arr[i-1]%2 == 1 && arr[i]%2 == 1 && arr[i+1]%2==1) return true;
        }
        return false;
    }
}