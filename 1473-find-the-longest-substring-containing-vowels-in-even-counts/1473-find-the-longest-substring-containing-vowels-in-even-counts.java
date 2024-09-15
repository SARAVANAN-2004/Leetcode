class Solution {

    public int findTheLongestSubstring(String s) {
        // Bitmask to track vowel counts using 5 bits (one for each vowel)
        int prefixXOR = 0;

        // Map to store first occurrence of each prefixXOR
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Initial value: prefixXOR 0 occurs before the string starts

        // Encoding vowels as bits
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;   // 00001 for 'a'
        characterMap['e' - 'a'] = 2;   // 00010 for 'e'
        characterMap['i' - 'a'] = 4;   // 00100 for 'i'
        characterMap['o' - 'a'] = 8;   // 01000 for 'o'
        characterMap['u' - 'a'] = 16;  // 10000 for 'u'

        int longestSubstring = 0;

        // Iterate through the string and apply XOR bitmask
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is a vowel, toggle its bit in prefixXOR
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                prefixXOR ^= characterMap[ch - 'a'];  // Toggle vowel's bit
            }

            // If the current prefixXOR has been seen before, calculate the substring length
            if (!map.containsKey(prefixXOR)) {
                // First time seeing this prefixXOR, store the index
                map.put(prefixXOR, i);
            } else {
                // Calculate the length of the substring from the first occurrence
                longestSubstring = Math.max(longestSubstring, i - map.get(prefixXOR));
            }
        }

        return longestSubstring;  // Return the longest valid substring length
    }
}
