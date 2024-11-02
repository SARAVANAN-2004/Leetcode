class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");

        return solve(arr);
    }

    boolean solve(String[] arr){
        int n = arr.length;
        // if(arr[0].charAt(0) != arr[n-1].charAt(arr[n-1].length()-1) || !check(arr[0])){
        //     return false;
        // }


        for(int  i= 0;i<n;i++){
            int a = i+1;
            if(a == n){
                a = 0;
            }
            // System.out.println(arr[i]+" "+arr[a]);
            if(arr[a].charAt(0) != arr[i].charAt(arr[i].length()-1) || !check(arr[i])){         
            // System.out.println(i + " "+a);
            return false;
        }
        }


        return true;
    }
    boolean check(String s){
        for(char ch:s.toCharArray()){
            if(!Character.isLetter(ch)){
                
                return false;
            }
        }
        return true;
    }
}