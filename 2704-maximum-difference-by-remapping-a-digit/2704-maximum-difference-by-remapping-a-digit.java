class Solution {
    public int minMaxDifference(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        char st = arr[0];
        char m = '-';
        char[] max = Arrays.copyOf(arr,n);
        char[] min = Arrays.copyOf(arr,n);
        for(char ch:arr){
            if(ch != '9'){
                m = ch;
                break;
            }
        }
        // System.out.println(m+" "+st);
        for(int i = 0;i<n;i++){
            if(arr[i] == st){
                min[i]  = '0';
            }

            if(arr[i] == m){
                max[i] = '9';
            }
        }
        
        return Integer.valueOf(String.valueOf(max)) - Integer.valueOf(String.valueOf(min));
    }
}