class Solution {
    public int maximumSwap(int num) {
       String s = ""+num;
       int n = s.length();
       int max = num;
       for(int i = 0;i <n-1;i++){
            for(int j = i+1;j<n;j++){
                if(s.charAt(i) - '0' < s.charAt(j)-'0'){
int next = Integer.valueOf(""+s.substring(0,i)+s.charAt(j)+s.substring(i+1,j)+s.charAt(i)+s.substring(j+1));
                    max = Math.max(next,max);
                    // System.out.println(next);
                }
            }
       }

       return max;
    }
}