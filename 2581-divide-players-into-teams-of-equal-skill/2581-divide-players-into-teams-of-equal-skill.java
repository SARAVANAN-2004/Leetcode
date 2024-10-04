class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int l = 0, r = n -1;
        long sum = 0;
        int val = skill[0]+skill[n-1];
        while(l < r){
            int newVal = skill[l]+skill[r];
            if(val!=newVal){
                return -1;
            }
            sum += (skill[l]*skill[r]);
            l++;
            r--;
        }
        return sum;
    }
}