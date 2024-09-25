class TrieNode{
    TrieNode[] next = new TrieNode[26];
    int cnt = 0;
}

class Solution {
    TrieNode root = new TrieNode();

    void insert(String word){
        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(node.next[c - 'a'] == null){
            node.next[c - 'a'] = new TrieNode();
            }
            node.next[c - 'a'].cnt++;
            node = node.next[c-'a'];
        }
    }

    int count(String s){
        TrieNode node = root;
        int cnt = 0;
        for(char c:s.toCharArray()){
            cnt += node.next[c - 'a'].cnt;
            node = node.next[c - 'a'];
        }
        return cnt;
    }
    public int[] sumPrefixScores(String[] words) {
        // Map<String,Integer> map = new HashMap<>();
        for(String s:words){
            insert(s);
        }
        // System.out.println(map);
        int[] ans = new int[words.length];
        int idx = 0;
        for(String s:words){
            ans[idx++] = count(s);
        }
        return ans;
    }
}