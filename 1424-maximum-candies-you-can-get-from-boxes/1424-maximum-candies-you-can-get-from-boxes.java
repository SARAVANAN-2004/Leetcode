class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] vis = new boolean[n];
        int sum = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i:initialBoxes){
            que.add(i);
        }
        boolean relax = true;
        while(!que.isEmpty() && relax){
            relax = false;
            int size = que.size();
            for(int i = 0;i<size;i++){
                int box = que.poll();
                if(status[box] == 1){
                    sum += candies[box];
                    for(int k :keys[box]){
                        relax = true;
                        status[k] = 1;
                    }
                    for(int c:containedBoxes[box]){
                        relax = true;
                        que.add(c);
                    }
                }else{
                    que.add(box);
                }

            }
        }
        return sum;
    }
}