class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i].length() == 0) continue;
            // System.out.println();
            sb.append(arr[i]);
            if(i !=0) sb.append(" ");
        }
        return sb.toString().trim();
    }
}