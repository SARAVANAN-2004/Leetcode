
class Node{
    Node[] child;
    boolean flag;

    public Node(){
        child = new Node[26];
        flag = false;
    }
}



class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(node.child[i] == null){
                node.child[i] = new Node();
            }
            node = node.child[i];
        }

        node.flag = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch:word.toCharArray()){
            int i = ch-'a';
            if(node.child[i] == null){
                return false;
            }
            node = node.child[i];
        }
        return node.flag;
    }

}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word:wordDict){
            trie.insert(word);
        }
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(dp[j] && trie.search(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

}