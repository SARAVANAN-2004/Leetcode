class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> arr;
    public RandomizedSet() {
        map  = new HashMap<>();
        arr = new ArrayList<>();

    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int idx = map.get(val);
            arr.set(idx,arr.get(arr.size()-1));
            map.put(arr.get(idx),idx);
            arr.remove(arr.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int size = arr.size();
        Random rand = new Random();
        int idx = rand.nextInt(size);
        return arr.get(idx);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */