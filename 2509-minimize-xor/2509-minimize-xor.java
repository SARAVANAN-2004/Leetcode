class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt1 = Integer.bitCount(num1);
        int cnt2 = Integer.bitCount(num2);
        if(cnt1 == cnt2) return num1;
        if(cnt1 > cnt2){
            char[] arr = Integer.toBinaryString(num1).toCharArray();
            // System.out.println(Arrays.toString(arr));
            for(int i = arr.length-1;i>=0 && cnt1 > cnt2;i--){
                if(arr[i] == '1'){
                    arr[i] = '0';
                    cnt1--;
                }
            }
            return Integer.parseInt(String.valueOf(arr),2);
        }
        // System.out.println(cnt1+" "+cnt2);
        // System.out.println(Integer.toBinaryString(num1));
        // System.out.println(Integer.toBinaryString(num2));
        char[] arr = Integer.toBinaryString(num1).toCharArray();
        // System.out.println(Arrays.toString(arr));
        for(int i = arr.length-1;i>=0 && cnt1 < cnt2;i--){
            if(arr[i] == '0'){
                arr[i] = '1';
                cnt1++;
            }
        }
        num1 =  Integer.parseInt(String.valueOf(arr),2);
        while(cnt1 < cnt2){
            num1 = (num1<<1)+1;
            cnt1++;
        }
        return num1;
      
        
    }
}