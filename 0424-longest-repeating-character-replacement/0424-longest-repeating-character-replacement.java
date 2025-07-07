class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int[] map = new int[26];
        int maxi  = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        while(j < n){
            map[arr[j] - 'A']++;
            int curMax = 0, sum = 0;
            
            for(int l = 0;l<26;l++){
                if(map[l] >= curMax){
                    sum += curMax;
                    curMax = map[l];
                }else{
                    sum += map[l];
                }
            }
            // System.out.println(j+" "+i+" "+curMax+" "+sum);

            while(i < j && sum > k){
                map[arr[i] - 'A']--;
                    curMax = 0;
                    sum = 0;
                for(int l = 0;l<26;l++){
                    if(map[l] > curMax){
                        sum += curMax;
                        curMax = map[l];
                    }else{
                        sum += map[l];
                    }
                }
                i++;
            }
            maxi = Math.max(maxi,curMax + sum);

            
            j++;
        }
        return maxi;
    }
}