class SmallestInfiniteSet {
    PriorityQueue<Integer> que = new PriorityQueue<>();
    boolean[] vis = new boolean[1001];
    int cur = 1;
    public SmallestInfiniteSet() {
        
    }
    public int popSmallest() {
        if(!vis[cur]) {
            que.offer(cur);
            vis[cur] = true;
        }
        int min = que.poll();
        if(min == cur){
            cur++;
        }
        vis[min] = false;
        return min;
    }
    
    public void addBack(int num) {
        if(num < cur && !vis[num]){
            que.offer(num);
            vis[num] = true;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */