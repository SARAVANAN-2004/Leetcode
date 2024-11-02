class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");

        return solve(arr);
    }

    boolean solve(String[] arr){
        int n = arr.length;
       

        for(int  i= 0;i<n;i++){
            int a = i+1;
            if(a == n){
                a = 0;
            }
            // System.out.println(arr[i]+" "+arr[a]);
            if(arr[a].charAt(0) != arr[i].charAt(arr[i].length()-1)){         
            // System.out.println(i + " "+a);
            return false;
        }
        }


        return true;
    }
    // boolean check(String s){
    //     for(char ch:s.toCharArray()){
    //         if(!Character.isLetter(ch)){
                
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}