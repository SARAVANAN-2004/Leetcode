class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        return getChalkReplacer(chalk, k);
    }
    public int getChalkReplacer(int[] chalk, int remaining_chalk) {
        int chalk_sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            chalk_sum += chalk[i];
            if (remaining_chalk - chalk_sum < 0) {
                return i;
            }
        }
        return getChalkReplacer(chalk, (int) (remaining_chalk % chalk_sum));
    }
}