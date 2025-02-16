class RandomizedSet {
    Set<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int size = set.size();
        Random rand = new Random();
        int num = rand.nextInt(size)-1;
        int val = 0;
        int n = 0;
        for(int i :set){
            if(val == num){
                return i;
            }
            val++;
            n = i;
        }
        return n;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */