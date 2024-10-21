class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return find(0, s, set);
    }

    int find(int index, String s, Set<String> set) {
        if (index == s.length()) {
            return set.size();
        }

        int maximum = 0;

        for (int i = index + 1; i <= s.length(); i++) {
            String currentSubstring = s.substring(index, i);
            if (!set.contains(currentSubstring)) {
                set.add(currentSubstring);
                maximum = Math.max(maximum, find(i, s, set));
                set.remove(currentSubstring);
            }
        }

        return maximum;
    }
}