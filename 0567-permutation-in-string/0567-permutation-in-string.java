class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = s1.length();
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        Set<char[]> set = new HashSet<>();
        set.add(ch1);
        for(int i = 0;i< s2.length()-l+1;i++){
            char[] ch2 = s2.substring(i,l+i).toCharArray();
            Arrays.sort(ch2);
            if(valid(ch1,ch2)){
                return true;
            }
            // System.out.println(s2.substring(i,l+i));
        }
        return false;
    }
    boolean valid(char[] arr1,char[] arr2){
        for(int i = 0;i <arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    
}