class Solution {
   
    public static boolean increasingTriplet(int[] nums) {
       int first=Integer.MAX_VALUE,sec=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=first) first=num;
            else if(num<=sec) sec=num;
            else return true;
        }
        return false;
       
    }
}