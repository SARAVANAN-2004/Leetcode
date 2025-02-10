class Solution {
    class Pair{
        int step;
        String word;
        public Pair(String word,int step){
            this.step = step;
            this.word = word;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!que.isEmpty()){
            String s = que.peek().word;
            int step = que.peek().step;
            que.poll();
            if(s.equals(endWord)) return step;
            for(int i = 0;i<s.length();i++){
                for(int idx = 0;idx < 26;idx++){
                    char[] arr = s.toCharArray();
                    arr[i] = (char)('a'+idx);
                    if(set.contains(String.valueOf(arr))){
                        que.add(new Pair(String.valueOf(arr),step+1));
                        set.remove(String.valueOf(arr));
                    }
                }
            }
        }
        return 0;
    }
}