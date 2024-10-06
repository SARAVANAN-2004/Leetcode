class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] str1 = sentence1.split(" ");
        String[] str2 = sentence2.split(" ");
        String[] s1 = str1.length > str2.length ? str2 : str1;
        String[] s2 = str1.length > str2.length ? str1 : str2;
        int i = 0;
        int j = 0;
        int n1 = s1.length,n2 = s2.length;
        while(i < n1 && s1[i].equals(s2[i])){
            i++;
        }
        while(j <n1-i && s2[n2 -j-1].equals(s1[n1-j-1])){
            j++;
        }
        return i+j == n1;
    }
}