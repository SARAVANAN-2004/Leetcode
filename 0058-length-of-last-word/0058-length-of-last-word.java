class Solution {
    public int lengthOfLastWord(String s) {
        String[] a = s.split("\\s+");
        // System.out.println(Arrays.toString(a));
        return a[a.length-1].length();
    }
}