class Solution {
    public String repeatLimitedString(String s, int limit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->b-a);

        int[] map = new int[26];
        
        for(char ch:s.toCharArray()){
            if(map[ch-'a'] == 0){
                pq.add(ch);
            }
            map[ch-'a']++;
        }
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            char cur = pq.poll();
            int min = Math.min(limit,map[cur-'a']);
            for(int i = 0;i<min;i++){
                str.append(cur);
                
            }
            map[cur-'a'] -= min;
            if(map[cur-'a'] > 0){
                if (pq.isEmpty()) {
                    break;
                }

                
                char next = pq.poll();
                str.append(next);
                map[next - 'a']--;

               
                if (map[next - 'a'] > 0) {
                    pq.add(next);
                }
                pq.add(cur);
            }
        }
        return str.toString();

    }
}