class Solution {
    public int maxDiff(int num) {
        if(num < 10) return 8;
        String s = ""+num;
        char[] arr = s.toCharArray();
        char[] maxi = Arrays.copyOf(arr,arr.length);
        char[] mini = Arrays.copyOf(arr,arr.length);
        char min = arr[0] , max = arr[0];
        for(char ch:arr){
            if(ch != '9'){
                max = ch;
                break;
            }
        }
        for(char ch:arr){
            if(ch != '1' && ch != '0'){
                min = ch;
                break;
            }
        }
        char minSwap = min == arr[0]? '1':'0';

        for(int i = 0;i<arr.length;i++){
            if(arr[i] == max){
                maxi[i] = '9';
            }
            if(arr[i] == min){
                mini[i] = minSwap;
            }
        }
        // System.out.println(Arrays.toString(maxi));
        // System.out.println(Arrays.toString(mini));

        return Integer.valueOf(String.valueOf(maxi)) -  Integer.valueOf(String.valueOf(mini));
    }
}