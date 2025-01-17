class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int i :derived){
            xor ^= i;
        }
        return xor == 0;
    }
}