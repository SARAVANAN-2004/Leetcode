class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        for(int  i= 0;i<n;i++){
            int a = i+1;
            if(a == n){
                a = 0;
            }
            if(arr[a].charAt(0) != arr[i].charAt(arr[i].length()-1)){         
            return false;
        }
        }
        return true;
    }
}