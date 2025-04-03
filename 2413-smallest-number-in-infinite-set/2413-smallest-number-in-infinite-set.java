class SmallestInfiniteSet {
    PriorityQueue<Integer> que = new PriorityQueue<>();
    boolean[] vis = new boolean[1001];
    
    public SmallestInfiniteSet() {
        for(int i = 1;i<1001;i++){
        que.add(i);
    }
    }
    public int popSmallest() {
        int cur = que.poll();
        vis[cur] = true;
        return cur;
    }
    
    public void addBack(int num) {
        if(vis[num]){
            que.add(num);
            vis[num] = false;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */